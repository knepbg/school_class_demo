package com.schoolclass.demo.converter;

import com.schoolclass.demo.dto.SubjectDto;
import com.schoolclass.demo.model.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter {

    public SubjectDto toSubjectDto(Subject subject) {
        return SubjectDto.builder()
                .id(subject.getId())
                .subjectName(subject.getSubjectName())
                .build();
    }

    public Subject toSubject(SubjectDto subjectDto) {
        return Subject.builder()
                .id(subjectDto.getId())
                .subjectName(subjectDto.getSubjectName())
                .build();
    }
}
