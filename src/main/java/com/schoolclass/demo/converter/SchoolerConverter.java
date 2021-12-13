package com.schoolclass.demo.converter;

import com.schoolclass.demo.dto.SchoolerDto;
import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.model.Schooler;
import org.springframework.stereotype.Component;

@Component
public class SchoolerConverter {

    public SchoolerDto toSchoolerDto (Schooler schooler) {
        return SchoolerDto.builder()
                .id(schooler.getId())
                .firstName(schooler.getFirstName())
                .lastName(schooler.getLastName())
                .numberInClass(schooler.getNumberInClass())
                .classRoomId(schooler.getClassRoom().getId())
                .build();
    }

    public Schooler toSchooler (SchoolerDto schoolerDto) {
        return Schooler.builder()
                .id(schoolerDto.getId())
                .firstName(schoolerDto.getFirstName())
                .lastName(schoolerDto.getLastName())
                .numberInClass(schoolerDto.getNumberInClass())
                .classRoom(ClassRoom.builder()
                        .id(schoolerDto.getClassRoomId())
                        .build())
                .build();
    }

}
