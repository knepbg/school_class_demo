package com.schoolclass.demo.service;

import com.schoolclass.demo.model.Subject;
import com.schoolclass.demo.model.Teacher;

import java.util.Set;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher, String ucn, Subject subject);

    void delete(String ucn);

    Teacher findByUcn(String ucn);

    Teacher findByTelephoneNumber(String telephoneNumber);

    Teacher findByEmailAddress(String emailAddress);

    Set<Teacher> findByFirstName(String firstName);

    Set<Teacher> findByLastName(String lastName);

    Set<Teacher> findAll();


}
