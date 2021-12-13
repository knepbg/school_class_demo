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
public class SubjectDto {

    private Long id;

    private String subjectName;

    private Set<Long> teachersId;

    private Set<Long> classRoomsId;

}
