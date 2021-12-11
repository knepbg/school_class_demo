package com.schoolclass.demo.service;

import com.schoolclass.demo.model.ClassRoom;

import java.util.Set;

public interface ClassRoomService {

    ClassRoom save(ClassRoom classRoom);

    void delete(Long id);

    Set<ClassRoom> findAll();

    ClassRoom findByName(String name);

    ClassRoom findById(Long id);

    ClassRoom update(ClassRoom classRoom, Long id);


}
