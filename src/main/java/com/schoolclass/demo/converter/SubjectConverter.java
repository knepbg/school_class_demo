package com.schoolclass.demo.converter;

import com.schoolclass.demo.dto.SubjectDto;
import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.model.Subject;
import com.schoolclass.demo.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SubjectConverter {

    public SubjectDto toSubjectDto(Subject subject) {
        return SubjectDto.builder()
                .id(subject.getId())
                .subjectName(subject.getSubjectName())
                .teachersId(subject.getTeachers()
                        .stream()
                        .map(Teacher::getId)
                        .collect(Collectors.toSet()))
                .classRoomsId(subject.getClassRooms()
                        .stream()
                        .map(ClassRoom::getId)
                        .collect(Collectors.toSet()))

                .build();
    }

    public Subject toSubject(SubjectDto subjectDto) {
        return Subject.builder()
                .id(subjectDto.getId())
                .subjectName(subjectDto.getSubjectName())
                .teachers(subjectDto.getTeachersId()
                        .stream()
                        .map((teachersId) ->
                                Teacher.builder()
                                        .id(teachersId)
                                        .build())
                        .collect(Collectors.toSet()))
                .classRooms(subjectDto.getClassRoomsId()
                        .stream()
                        .map((classRoomsId) ->
                                ClassRoom.builder()
                                        .id(classRoomsId)
                                        .build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
