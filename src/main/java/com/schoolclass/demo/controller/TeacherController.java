package com.schoolclass.demo.controller;

import com.schoolclass.demo.converter.TeacherConverter;
import com.schoolclass.demo.dto.TeacherDto;
import com.schoolclass.demo.dto.TeacherResponse;
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
        Teacher requestSaveTeacherDto = teacherConverter.toTeacher(teacherDto);
        Teacher savedTeacher = teacherService.save(requestSaveTeacherDto);
        return ResponseEntity.ok(teacherConverter.toTeacherResponse(savedTeacher));
    }

    @GetMapping
    public ResponseEntity<Set<TeacherDto>> findAll() {
        Set<Teacher> foundTeachers = teacherService.findAll();
        Set<TeacherDto> responseTeachersDto = foundTeachers.stream()
                .map(teacherConverter::toTeacherDto)
                .collect(Collectors.toSet());
        return ResponseEntity.ok(responseTeachersDto);
    }
}
