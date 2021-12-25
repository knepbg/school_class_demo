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
public class TeacherResponse {

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String emailAddress;

    private Set<SubjectResponse> subjectResponses;
}
