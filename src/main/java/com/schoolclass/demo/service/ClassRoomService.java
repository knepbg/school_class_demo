package com.schoolclass.demo.service;

import com.schoolclass.demo.model.ClassRoom;

import java.util.Set;

public interface ClassRoomService {

    ClassRoom save(ClassRoom classRoom);

    void delete(Long id);

    Set<ClassRoom> findAll();

    Set<ClassRoom> findByClassRoomName(String classRoomName);

    ClassRoom findById(Long id);

    ClassRoom update(ClassRoom classRoom, Long id);


}
