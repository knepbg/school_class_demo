package com.schoolclass.demo.dto.teacherDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TeacherResponseDelete {

    private String action;

    private String firstName;

    private String lastName;
}
