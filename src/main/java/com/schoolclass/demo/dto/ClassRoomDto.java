package com.schoolclass.demo.dto;

import com.schoolclass.demo.model.Schooler;
import com.schoolclass.demo.model.Subject;
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

    private Long id;

    private String classRoomName;

    private Integer classYear;

    private String classProfile;

    private Set<Schooler> schoolers;

    private Set<Subject> subjects;
}
