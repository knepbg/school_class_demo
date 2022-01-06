package com.schoolclass.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TeacherDto {

    @Size(max = 20, message = "First name must be between  20 chars max.")
    private String firstName;

    @Size(max = 20, message = "Last name must be between  20 chars max.")
    private String lastName;

    @Size(max = 10, message = "Max 10 chars")
    private String ucn;

    @Size(max = 13, message = "Max 13 chars")
    private String telephoneNumber;

    @Email
    private String emailAddress;

    private Set<Long> subjectsId;
}
