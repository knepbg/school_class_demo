package com.schoolclass.demo.controller;

import com.schoolclass.demo.converter.TeacherConverter;
import com.schoolclass.demo.dto.TeacherDto;
import com.schoolclass.demo.dto.TeacherResponse;
import com.schoolclass.demo.dto.TeacherResponseDelete;
import com.schoolclass.demo.model.Teacher;
import com.schoolclass.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherConverter teacherConverter;

    @Autowired
    public TeacherController(TeacherService teacherService, TeacherConverter teacherConverter) {
        this.teacherService = teacherService;
        this.teacherConverter = teacherConverter;
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> save(@RequestBody TeacherDto teacherDto) {
        Teacher requestSaveTeacher = teacherConverter.toTeacher(teacherDto);
        Teacher savedTeacher = teacherService.save(requestSaveTeacher);
        TeacherResponse teacherResponse = teacherConverter.toTeacherResponse(savedTeacher);
        return ResponseEntity.ok(teacherResponse);
    }

    @GetMapping
    public ResponseEntity<Set<TeacherResponse>> findAll() {
        Set<Teacher> foundTeachers = teacherService.findAll();
        Set<TeacherResponse> teacherResponses = foundTeachers.stream()
                .map(teacherConverter::toTeacherResponse)
                .collect(Collectors.toSet());
        return ResponseEntity.ok(teacherResponses);
    }

    @PutMapping(value = "/{ucn}/telephoneNumber/{telephoneNumber}")
    public ResponseEntity<TeacherResponse> updateTeacherTelephoneNumber(@PathVariable String ucn,
                                                                        @PathVariable String telephoneNumber) {
        Teacher updatedTeacher = teacherService.updateTeacherTelephoneNumber(ucn, telephoneNumber);
        TeacherResponse teacherResponse = teacherConverter.toTeacherResponse(updatedTeacher);
        return ResponseEntity.ok(teacherResponse);

    }

    @PutMapping(value = "/{ucn}/emailAddress/{emailAddress}")
    public ResponseEntity<TeacherResponse> updateTeacherEmailAddress(@PathVariable String ucn,
                                                                     @PathVariable String emailAddress) {
        Teacher updatedTeacher = teacherService.updateTeacherEmailAddress(ucn, emailAddress);
        TeacherResponse teacherResponse = teacherConverter.toTeacherResponse(updatedTeacher);
        return ResponseEntity.ok(teacherResponse);

    }

    @PutMapping(value = "/{ucn}/add-subject/{subjectName}")
    public ResponseEntity<TeacherResponse> addTeacherSubject(@PathVariable String ucn,
                                                             @PathVariable String subjectName) {
        Teacher updatedTeacher = teacherService.addTeacherSubject(ucn, subjectName);
        TeacherResponse teacherResponse = teacherConverter.toTeacherResponse(updatedTeacher);
        return ResponseEntity.ok(teacherResponse);

    }

    @PutMapping(value = "/{ucn}/delete-subject/{subjectName}")
    public ResponseEntity<TeacherResponse> deleteTeacherSubject(@PathVariable String ucn,
                                                                @PathVariable String subjectName) {
        Teacher updatedTeacher = teacherService.deleteTeacherSubject(ucn, subjectName);
        TeacherResponse teacherResponse = teacherConverter.toTeacherResponse(updatedTeacher);
        return ResponseEntity.ok(teacherResponse);

    }

    @DeleteMapping(value = "/{ucn}")
    public ResponseEntity<TeacherResponseDelete> deleteTeacher(@PathVariable String ucn) {
        TeacherResponseDelete teacherForDelete = TeacherResponseDelete.builder()
                .action("Delete")
                .firstName(teacherService.findByUcn(ucn).getFirstName())
                .lastName(teacherService.findByUcn(ucn).getLastName())
                .build();
        teacherService.delete(ucn);
        return ResponseEntity.ok(teacherForDelete);
    }


}
