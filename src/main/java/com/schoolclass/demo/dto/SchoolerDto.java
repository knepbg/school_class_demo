package com.schoolclass.demo.dto;

import com.schoolclass.demo.model.ClassRoom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SchoolerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String numberInClass;

    private Long classRoomId;

}
