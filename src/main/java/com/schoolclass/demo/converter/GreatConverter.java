package com.schoolclass.demo.converter;

import com.schoolclass.demo.dto.GreatDto;
import com.schoolclass.demo.model.Great;
import org.springframework.stereotype.Component;

@Component
public class GreatConverter {

    public GreatDto toGreatDto(Great great) {
        return GreatDto.builder()
                .greatName(great.getGreatName())
                .greatValue(great.getGreatValue())
                .build();
    }

    public Great toGreat(GreatDto greatDto) {
        return Great.builder()
                .greatName(greatDto.getGreatName())
                .greatValue(greatDto.getGreatValue())
                .build();
    }
}
