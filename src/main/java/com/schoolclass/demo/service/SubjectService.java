package com.schoolclass.demo.service;

import com.schoolclass.demo.model.Subject;

import java.util.Set;

public interface SubjectService {

    Subject save(Subject subject);

    Subject update(Long id, Subject subject);

    void delete(String subjectName);

    Subject findBySubjectName(String subjectName);

    Subject findById(Long id);

    Set<Subject> findAll();
}
