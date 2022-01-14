package com.schoolclass.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "greats")
public class Great {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true, length = 10)
    private String greatName;

    @NotNull
    @Column(unique = true, nullable = false)
    @Size(min = 2, max = 6, message = "GreatValue must be between 2 and 6")
    private Integer greatValue;

}
