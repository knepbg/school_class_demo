package com.schoolclass.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ClassRoomDto {


    private String classRoomName;

    private Integer classYear;

    private String classProfile;

    private Set<Long> schoolersId;

    private Set<Long> subjectsId;
}
