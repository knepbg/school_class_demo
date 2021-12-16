package com.schoolclass.demo.controller;

import com.schoolclass.demo.converter.SubjectConverter;
import com.schoolclass.demo.dto.SubjectDto;
import com.schoolclass.demo.model.Subject;
import com.schoolclass.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectConverter subjectConverter;

    @Autowired
    public SubjectController(SubjectService subjectService, SubjectConverter subjectConverter) {
        this.subjectService = subjectService;
        this.subjectConverter = subjectConverter;
    }

    @PostMapping
    public ResponseEntity<SubjectDto> save(@RequestBody SubjectDto subjectDto) {
        Subject subject = subjectConverter.toSubject(subjectDto);
        Subject savedSubject = subjectService.save(subject);
        return ResponseEntity.ok(subjectConverter.toSubjectDto(savedSubject));
    }

    @GetMapping
    public ResponseEntity<Set<SubjectDto>> findAll() {
        Set<Subject> foundSubjects = subjectService.findAll();
        SortedSet<SubjectDto> responseSubjectDto = new TreeSet<>(Comparator.comparing(SubjectDto::getId));
        responseSubjectDto.addAll(foundSubjects.stream()
                .map(subjectConverter::toSubjectDto)
                .collect(Collectors.toSet()));
        return ResponseEntity.ok(responseSubjectDto);
    }
}
