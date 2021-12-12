package com.schoolclass.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false, updatable = false)
    private String ucn;

    // length 13 such as +359 876 123 456
    @NotNull
    @Column(unique = true, nullable = false)
    private String telephoneNumber;

    @Column(unique = true)
    private String emailAddress;

    @ManyToMany
    private Set<Subject> subjects;
}
