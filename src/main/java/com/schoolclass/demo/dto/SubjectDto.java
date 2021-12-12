package com.schoolclass.demo.dto;

import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SubjectDto {

    private Long id;

    private String subjectName;

    private Set<Teacher> teachers;

    private Set<ClassRoom> classRooms;

}
