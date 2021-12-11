package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.repository.ClassRoomRepository;
import com.schoolclass.demo.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private final ClassRoomRepository classRoomRepository;

    @Autowired
    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Set<ClassRoom> findAll() {
        return null;
    }

    @Override
    public ClassRoom findByName(String name) {
        return null;
    }

    @Override
    public ClassRoom update(ClassRoom classRoom, Long id) {
        return null;
    }
}
