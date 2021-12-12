package com.schoolclass.demo.dto;

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
public class TeacherDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String ucn;

    private String telephoneNumber;

    private String emailAddress;

    private Set<Subject> subjects;
}
