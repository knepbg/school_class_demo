package com.schoolclass.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "schoolers")
public class Schooler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, length = 25)
    private String firstName;

    @NotNull
    @Column(nullable = false, length = 25)
    private String lastName;

    // number in class, such as 01,02,02 ...
    @NotNull
    @Column(nullable = false, unique = true)
    private String numberInClass;

    @ManyToOne
    private ClassRoom classRoom;
}
