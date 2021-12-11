package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Subject;
import com.schoolclass.demo.repository.SubjectRepository;
import com.schoolclass.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject save(Subject subject) {
        return null;
    }

    @Override
    public Subject update(Long id, Subject subject) {
        return null;
    }

    @Override
    public void delete(String subjectName) {

    }

    @Override
    public Subject findByName(Subject subjectName) {
        return null;
    }

    @Override
    public Set<Subject> findAll() {
        return null;
    }
}
