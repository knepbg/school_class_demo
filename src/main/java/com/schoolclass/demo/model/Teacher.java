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
    @Column(nullable = false, length = 25)
    private String firstName;

    @NotNull
    @Column(nullable = false, length = 25)
    private String lastName;

    @NotNull
    @Column(nullable = false, updatable = false, length = 10)
    private String ucn;

    // length 13 such as +359 876 123 456
    @NotNull
    @Column(unique = true, nullable = false, length = 13)
    private String telephoneNumber;

    @Column(unique = true, length = 25)
    private String emailAddress;

    @ManyToMany
    private Set<Subject> subjects;
}
