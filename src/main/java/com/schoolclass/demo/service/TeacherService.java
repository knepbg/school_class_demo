package com.schoolclass.demo.service;

import com.schoolclass.demo.model.Schooler;
import com.schoolclass.demo.model.Teacher;

import java.util.Set;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher, String ucn);

    void delete(String ucn);

    Teacher findByUcn(String ucn);

    Teacher findByTelephoneNumber(String telephoneNumber);

    Teacher findByEmailAddress(String emailAddress);

    Set<Schooler> findByFirstName(String firstName);

    Set<Schooler> findByLastName(String lastName);

    Set<Schooler> findAll();


}
