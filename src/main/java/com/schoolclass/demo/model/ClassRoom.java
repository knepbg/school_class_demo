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
@Table(name = "class_rooms")
public class ClassRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // className for example - a, b, c, d .. etc.
    @NotNull
    @Column(nullable = false, length = 10)
    private String classRoomName;


    // classYear - 1 , 2 , 3 ... etc. example : classYear + className = 1a, 1b,2a, 2b ... etc.
    // it can be done also with separate entities
    @NotNull
    @Column(nullable = false)
    private Integer classYear;


    // classProfile for example - Math, Information technology, biology .. etc.
    @NotNull
    @Column(nullable = false, length = 50)
    private String classProfile;

    @OneToMany(mappedBy = "classRoom")
    private Set<Schooler> schoolers;

    @ManyToMany
    private Set<Subject> subjects;

}
