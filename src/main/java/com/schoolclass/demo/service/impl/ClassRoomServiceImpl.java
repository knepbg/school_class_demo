package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.ClassRoom;
import com.schoolclass.demo.repository.ClassRoomRepository;
import com.schoolclass.demo.service.ClassRoomService;
import com.schoolclass.demo.service.SchoolerService;
import com.schoolclass.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private final ClassRoomRepository classRoomRepository;
    private final SchoolerService schoolerService;
    private final SubjectService subjectService;

    @Autowired
    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository, SchoolerService schoolerService, SubjectService subjectService) {
        this.classRoomRepository = classRoomRepository;
        this.schoolerService = schoolerService;
        this.subjectService = subjectService;
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
        SortedSet<ClassRoom> classRooms = new TreeSet<>(Comparator
                .comparing(ClassRoom::getId));
        classRooms.addAll(classRoomRepository.findAll());
        return classRooms;
    }

    //it will find for example 1a , 2a, 3a .. ?
    @Override
    public Set<ClassRoom> findByClassRoomName(String classRoomName) {
        return new HashSet<>(classRoomRepository.findByClassRoomName(classRoomName));
    }

    // need to configure Exception
    @Override
    public ClassRoom findById(Long id) {
        return classRoomRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    // Only year of the class can be updated -- from 1 to 2 to 3 .. etc.
    @Override
    public ClassRoom update(ClassRoom classRoom, Long id) {
        ClassRoom foundedClassRoom = findById(id);
        ClassRoom updatedClassRoom = ClassRoom.builder()
                .id(foundedClassRoom.getId())
                .classYear(classRoom.getClassYear())
                .classProfile(classRoom.getClassProfile())
                .build();
        return classRoomRepository.save(updatedClassRoom);
    }
}
