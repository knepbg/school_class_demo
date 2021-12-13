package com.schoolclass.demo.controller;

import com.schoolclass.demo.converter.ClassRoomConverter;
import com.schoolclass.demo.dto.ClassRoomDto;
import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.service.ClassRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/classrooms")
public class ClassRoomController {

    private final ClassRoomService classRoomService;
    private final ClassRoomConverter classRoomConverter;

    public ClassRoomController(ClassRoomService classRoomService, ClassRoomConverter classRoomConverter) {
        this.classRoomService = classRoomService;
        this.classRoomConverter = classRoomConverter;
    }

    @PostMapping
    public ResponseEntity<ClassRoomDto> save (@RequestBody ClassRoomDto classRoomDto){
        ClassRoom classRoom = classRoomConverter.toClassRoom(classRoomDto);
        ClassRoom savedClassRoom = classRoomService.save(classRoom);
        ClassRoomDto classRoomDtoResponse = classRoomConverter.toClassRoomDto(savedClassRoom);
        return ResponseEntity.ok(classRoomDtoResponse);

    }
}
