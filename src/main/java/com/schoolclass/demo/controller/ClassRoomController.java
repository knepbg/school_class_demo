package com.schoolclass.demo.controller;

import com.schoolclass.demo.converter.ClassRoomConverter;
import com.schoolclass.demo.dto.ClassRoomDto;
import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.service.ClassRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

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
    public ResponseEntity<ClassRoomDto> save(@RequestBody ClassRoomDto classRoomDto) {
        ClassRoom classRoom = classRoomConverter.toClassRoom(classRoomDto);
        ClassRoom savedClassRoom = classRoomService.save(classRoom);
        ClassRoomDto classRoomDtoResponse = classRoomConverter.toClassRoomDto(savedClassRoom);
        return ResponseEntity.ok(classRoomDtoResponse);

    }

    @GetMapping
    public ResponseEntity<Set<ClassRoomDto>> findAll() {
        Set<ClassRoom> foundAll = classRoomService.findAll();
        Set<ClassRoomDto> responseClassRoomDto = foundAll
                .stream()
                .map(classRoomConverter::toClassRoomDto)
                .collect(Collectors.toSet());
        return ResponseEntity.ok(responseClassRoomDto);

    }
}
