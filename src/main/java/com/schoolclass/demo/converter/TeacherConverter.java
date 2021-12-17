package com.schoolclass.demo.converter;

import com.schoolclass.demo.dto.SubjectDto;
import com.schoolclass.demo.dto.TeacherDto;
import com.schoolclass.demo.dto.TeacherResponse;
import com.schoolclass.demo.model.Subject;
import com.schoolclass.demo.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeacherConverter {

    public TeacherDto toTeacherDto(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .emailAddress(teacher.getEmailAddress())
                .telephoneNumber(teacher.getTelephoneNumber())
                .ucn(teacher.getUcn())
                .subjectsId(teacher.getSubjects()
                        .stream()
                        .map(Subject::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Teacher toTeacher(TeacherDto teacherDto) {
        return Teacher.builder()
                .id(teacherDto.getId())
                .firstName(teacherDto.getFirstName())
                .lastName(teacherDto.getLastName())
                .ucn(teacherDto.getUcn())
                .telephoneNumber(teacherDto.getTelephoneNumber())
                .emailAddress(teacherDto.getEmailAddress())
                .subjects(teacherDto.getSubjectsId()
                        .stream()
                        .map((subjectsId) ->
                                Subject.builder()
                                        .id(subjectsId)
                                        .build())
                        .collect(Collectors.toSet()))
                .build();
    }

    public TeacherResponse toTeacherResponse(Teacher teacher) {
        return TeacherResponse.builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .telephoneNumber(teacher.getTelephoneNumber())
                .emailAddress(teacher.getEmailAddress())
                .subjectDtos(teacher.getSubjects().stream().map(Subject ->
                                SubjectDto.builder()
                                        .subjectName(Subject.getSubjectName())
                                        .build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
