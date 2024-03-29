package com.schoolclass.demo.controller;

import com.schoolclass.demo.converter.TeacherConverter;
import com.schoolclass.demo.dto.teacherDto.TeacherDto;
import com.schoolclass.demo.dto.teacherDto.TeacherResponse;
import com.schoolclass.demo.dto.teacherDto.TeacherResponseDelete;
import com.schoolclass.demo.model.Teacher;
import com.schoolclass.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    public ResponseEntity<TeacherResponse> save(@RequestBody @Valid TeacherDto teacherDto) {
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

    @PutMapping(value = "/{ucn}/telephone-number/{telephoneNumber}")
    public ResponseEntity<TeacherResponse> updateTeacherTelephoneNumber(@PathVariable String ucn,
                                                                        @PathVariable @Valid String telephoneNumber) {
        Teacher updatedTeacher = teacherService.updateTeacherTelephoneNumber(ucn, telephoneNumber);
        TeacherResponse teacherResponse = teacherConverter.toTeacherResponse(updatedTeacher);
        return ResponseEntity.ok(teacherResponse);

    }

    @PutMapping(value = "/{ucn}/email-address/{emailAddress}")
    public ResponseEntity<TeacherResponse> updateTeacherEmailAddress(@PathVariable String ucn,
                                                                     @PathVariable @Valid String emailAddress) {
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

    @GetMapping(value = "/first-name/{firstName}")
    public ResponseEntity<List<TeacherResponse>> findByFirstName(@PathVariable String firstName) {
        List<Teacher> foundTeachers = teacherService.findByFirstName(firstName);
        List<TeacherResponse> teacherResponseSet = foundTeachers.stream()
                .map(teacherConverter::toTeacherResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(teacherResponseSet);
    }

    @GetMapping(value = "/last-name/{lastName}")
    public ResponseEntity<List<TeacherResponse>> findByLastName(@PathVariable String lastName) {
        List<Teacher> foundTeachers = teacherService.findByLastName(lastName);
        List<TeacherResponse> teacherResponseSet = foundTeachers.stream()
                .map(teacherConverter::toTeacherResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(teacherResponseSet);
    }

    @GetMapping(value = "/telephone-number/{telephoneNumber}")
    public ResponseEntity<TeacherResponse> findByTelephoneNumber(@PathVariable String telephoneNumber) {
        Teacher foundTeacher = teacherService.findByTelephoneNumber(telephoneNumber);
        return ResponseEntity.ok(teacherConverter.toTeacherResponse(foundTeacher));
    }

    @GetMapping(value = "/email-address/{emailAddress}")
    public ResponseEntity<TeacherResponse> findByEmailAddress(@PathVariable @Valid String emailAddress) {
        Teacher foundTeacher = teacherService.findByEmailAddress(emailAddress);
        return ResponseEntity.ok(teacherConverter.toTeacherResponse(foundTeacher));
    }


}
