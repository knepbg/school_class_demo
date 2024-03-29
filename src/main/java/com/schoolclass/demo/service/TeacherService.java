package com.schoolclass.demo.service;

import com.schoolclass.demo.model.Teacher;

import java.util.List;
import java.util.Set;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher updateTeacherEmailAddress(String ucn, String emailAddress);

    Teacher updateTeacherTelephoneNumber(String ucn, String telephoneNumber);

    Teacher addTeacherSubject(String ucn, String subjectName);

    Teacher deleteTeacherSubject(String ucn, String subjectName);

    void delete(String ucn);

    Teacher findByUcn(String ucn);

    Teacher findByTelephoneNumber(String telephoneNumber);

    Teacher findByEmailAddress(String emailAddress);

    List<Teacher> findByFirstName(String firstName);

    List<Teacher> findByLastName(String lastName);

    Set<Teacher> findAll();


}
