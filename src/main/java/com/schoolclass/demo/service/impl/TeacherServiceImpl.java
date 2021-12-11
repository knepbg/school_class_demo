package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Schooler;
import com.schoolclass.demo.model.Teacher;
import com.schoolclass.demo.repository.TeacherRepository;
import com.schoolclass.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher update(Teacher teacher, String ucn) {
        return null;
    }

    @Override
    public void delete(String ucn) {

    }

    @Override
    public Teacher findByUcn(String ucn) {
        return null;
    }

    @Override
    public Teacher findByTelephoneNumber(String telephoneNumber) {
        return null;
    }

    @Override
    public Teacher findByEmailAddress(String emailAddress) {
        return null;
    }

    @Override
    public Set<Schooler> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public Set<Schooler> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Schooler> findAll() {
        return null;
    }
}
