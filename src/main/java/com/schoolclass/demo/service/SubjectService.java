package com.schoolclass.demo.service;

import com.schoolclass.demo.model.Subject;

import java.util.Optional;
import java.util.Set;

public interface SubjectService {

   Subject save(Subject subject);

    Subject update(Long id, Subject subject);

    void delete(String subjectName);

    // subjectName in unique
   Subject findBySubjectName(String subjectName);

    Subject findById(Long id);

    Set<Subject> findAll();
}
