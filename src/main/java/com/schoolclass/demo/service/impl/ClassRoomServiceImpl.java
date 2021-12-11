package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.repository.ClassRoomRepository;
import com.schoolclass.demo.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private final ClassRoomRepository classRoomRepository;

    @Autowired
    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    // validation needed
    @Override
    public void delete(Long id) {
        classRoomRepository.deleteById(id);
    }


    @Override
    public Set<ClassRoom> findAll() {
        SortedSet<ClassRoom> classRooms = new TreeSet<>(Comparator.comparing(ClassRoom::getId));
        classRooms.addAll(classRoomRepository.findAll());
        return classRooms;
    }

    // validation needed
    @Override
    public ClassRoom findByName(String name) {
        return classRoomRepository.findByName(name);
    }

    // need to configure Exception
    @Override
    public ClassRoom findById(Long id) {
        return classRoomRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    // Only year of the class can be updated -- from 1 to 2 to 3 .. etc.
    @Override
    public ClassRoom update(ClassRoom classRoom, Long id) {
        ClassRoom foundedClassRoom = findById(id);
        ClassRoom updatedClassRoom = ClassRoom.builder()
                .id(foundedClassRoom.getId())
                .classYear(classRoom.getClassYear())
                .build();
        return classRoomRepository.save(updatedClassRoom);
    }
}
