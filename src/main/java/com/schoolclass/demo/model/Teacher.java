package com.schoolclass.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20,message = "First name must be between  20 chars max.")
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    @Size(max = 20,message = "Last name must be between  20 chars max.")
    private String lastName;

    @NotNull
    @Column(nullable = false, updatable = false, unique = true)
    @Size(min = 10,max = 10, message = "Ucn is 10 chars")
    private String ucn;


    @NotNull
    @Column(unique = true, nullable = false)
    @Size(max = 13)
    private String telephoneNumber;

    @Column(unique = true)
    @Email(message = "Email format is incorrect -->  xxxx@xxxx.xxx")
    private String emailAddress;

    @ManyToMany
    private Set<Subject> subjects;
}
