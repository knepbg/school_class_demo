package com.schoolclass.demo.dto.subjectDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SubjectDto {

    private Long id;

    private String subjectName;


}
