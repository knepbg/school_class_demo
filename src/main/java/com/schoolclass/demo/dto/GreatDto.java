package com.schoolclass.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class GreatDto {

    private String greatName;

    @Size(min = 2, max = 6, message = "GreatValue must be between 2 and 6")
    private Integer greatValue;
}
