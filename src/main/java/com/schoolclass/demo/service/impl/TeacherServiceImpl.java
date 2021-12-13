package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Teacher;
import com.schoolclass.demo.repository.TeacherRepository;
import com.schoolclass.demo.service.SubjectService;
import com.schoolclass.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectService subjectService;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, SubjectService subjectService) {
        this.teacherRepository = teacherRepository;
        this.subjectService = subjectService;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher, String ucn) {
        Teacher foundTeacher = findByUcn(ucn);
        Teacher updatedTeacher = Teacher.builder()
                .id(foundTeacher.getId())
                .emailAddress(teacher.getEmailAddress())
                .telephoneNumber(teacher.getTelephoneNumber())
                .build();
        return teacherRepository.save(updatedTeacher);
    }


    @Override
    public void delete(String ucn) {
        Teacher foundTeacher = findByUcn(ucn);
        teacherRepository.deleteById(foundTeacher.getId());
    }

    // need to config exception
    @Override
    public Teacher findByUcn(String ucn) {
        return teacherRepository.findByUcn(ucn)
                .orElseThrow(IllegalAccessError::new);
    }

    // need to config exception
    @Override
    public Teacher findByTelephoneNumber(String telephoneNumber) {
        return teacherRepository.findByTelephoneNumber(telephoneNumber)
                .orElseThrow(IllegalArgumentException::new);
    }

    // need to config exception
    @Override
    public Teacher findByEmailAddress(String emailAddress) {
        return teacherRepository.findByEmailAddress(emailAddress)
                .orElseThrow(IllegalArgumentException::new);
    }

    // need validations
    @Override
    public Set<Teacher> findByFirstName(String firstName) {
        SortedSet<Teacher> teachers = new TreeSet<>(Comparator
                .comparing(Teacher::getFirstName));
        teachers.addAll(teacherRepository.findByFirstName(firstName));
        return teachers;
    }


    //need validations
    @Override
    public Set<Teacher> findByLastName(String lastName) {
        SortedSet<Teacher> teachers = new TreeSet<>(Comparator
                .comparing(Teacher::getLastName));
        teachers.addAll(teacherRepository.findByLastName(lastName));
        return teachers;
    }

    @Override
    public Set<Teacher> findAll() {
        SortedSet<Teacher> teachers = new TreeSet<>(Comparator
                .comparing(Teacher::getId));
        teachers.addAll(teacherRepository.findAll());
        return teachers;
    }
}
