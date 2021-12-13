package com.schoolclass.demo.converter;

import com.schoolclass.demo.dto.ClassRoomDto;
import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.model.Schooler;
import com.schoolclass.demo.model.Subject;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClassRoomConverter {

    public ClassRoomDto toClassRoomDto(ClassRoom classRoom) {
        return ClassRoomDto.builder()
                .id(classRoom.getId())
                .classRoomName(classRoom.getClassRoomName())
                .classYear(classRoom.getClassYear())
                .classProfile(classRoom.getClassProfile())
                .schoolersId(classRoom.getSchoolers()
                        .stream()
                        .map(Schooler::getId)
                        .collect(Collectors.toSet()))
                .subjectsId(classRoom.getSubjects()
                        .stream()
                        .map(Subject::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public ClassRoom toClassRoom(ClassRoomDto classRoomDto) {
        return ClassRoom.builder()
                .id(classRoomDto.getId())
                .classRoomName(classRoomDto.getClassRoomName())
                .classYear(classRoomDto.getClassYear())
                .classProfile(classRoomDto.getClassProfile())
                .schoolers(classRoomDto.getSchoolersId()
                        .stream()
                        .map((schoolersId) ->
                                Schooler.builder().id(schoolersId).build())
                        .collect(Collectors.toSet()))
                .subjects(classRoomDto.getSubjectsId()
                        .stream()
                        .map((subjectsId) -> Subject.builder().id(subjectsId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
