package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Subject;
import com.schoolclass.demo.repository.SubjectRepository;
import com.schoolclass.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(Long id, Subject subject) {
        Subject findSubject = findById(id);
        Subject updatedSubject = Subject.builder()
                .id(findSubject.getId())
                .subjectName(subject.getSubjectName())
                .build();
        return subjectRepository.save(updatedSubject);
    }

    // subjectName is unique
    @Override
    public void delete(String subjectName) {
        Subject foundBySubjectName = findBySubjectName(subjectName);
        subjectRepository.deleteById(foundBySubjectName.getId());
    }

    // TODO: need to config exceptions
    // subject name is unique
    @Override
    public Subject findBySubjectName(String subjectName) {
        return subjectRepository.findBySubjectName(subjectName)
                .orElseThrow(IllegalArgumentException::new);
    }

    //TODO: need to config exceptions
    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Set<Subject> findAll() {
        SortedSet<Subject> subjects = new TreeSet<>(Comparator
                .comparing(Subject::getId));
        subjects.addAll(subjectRepository.findAll());
        return subjects;
    }
}
