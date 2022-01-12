package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.exception.DuplicateRecordException;
import com.schoolclass.demo.exception.ResourceNotFoundException;
import com.schoolclass.demo.model.Subject;
import com.schoolclass.demo.model.Teacher;
import com.schoolclass.demo.repository.TeacherRepository;
import com.schoolclass.demo.service.SubjectService;
import com.schoolclass.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

        try {
            Set<Subject> subjects1 = teacher.getSubjects().stream()
                    .map((subject) -> subjectService.findById(subject.getId()))
                    .collect(Collectors.toSet());

            Teacher savedTeacher = Teacher.builder()
                    .id(teacher.getId())
                    .telephoneNumber(teacher.getTelephoneNumber())
                    .emailAddress(teacher.getEmailAddress())
                    .firstName(teacher.getFirstName())
                    .lastName(teacher.getLastName())
                    .ucn(teacher.getUcn())
                    .subjects(subjects1)
                    .build();

            return teacherRepository.save(savedTeacher);

        } catch (Exception e) {

            throw new DuplicateRecordException(String.format("Duplicate Record"));

        }

    }

    @Override
    public Teacher addTeacherSubject(String ucn, String subjectName) {

        Teacher foundTeacher = findByUcn(ucn);

        Set<Subject> updatedSubjectsSet = new HashSet<>(foundTeacher.getSubjects());
        updatedSubjectsSet.add(subjectService.findBySubjectName(subjectName));

        Teacher updatedTeacher = Teacher.builder()
                .id(foundTeacher.getId())
                .firstName(foundTeacher.getFirstName())
                .lastName(foundTeacher.getLastName())
                .ucn(foundTeacher.getUcn())
                .emailAddress(foundTeacher.getEmailAddress())
                .telephoneNumber(foundTeacher.getTelephoneNumber())
                .subjects(updatedSubjectsSet)
                .build();
        return teacherRepository.save(updatedTeacher);
    }

    @Override
    public Teacher deleteTeacherSubject(String ucn, String subjectName) {

        Teacher foundTeacher = findByUcn(ucn);

        Set<Subject> updatedSubjectsSet = new HashSet<>(foundTeacher.getSubjects());
        updatedSubjectsSet.remove(subjectService.findBySubjectName(subjectName));

        Teacher updatedTeacher = Teacher.builder()
                .id(foundTeacher.getId())
                .firstName(foundTeacher.getFirstName())
                .lastName(foundTeacher.getLastName())
                .ucn(foundTeacher.getUcn())
                .emailAddress(foundTeacher.getEmailAddress())
                .telephoneNumber(foundTeacher.getTelephoneNumber())
                .subjects(updatedSubjectsSet)
                .build();
        return teacherRepository.save(updatedTeacher);

    }

    @Override
    public Teacher updateTeacherEmailAddress(String ucn, String emailAddress) {
        Teacher foundTeacher = findByUcn(ucn);
        try {
            findByEmailAddress(emailAddress);
            throw new DuplicateRecordException(String.format("Teacher with %s email, already exist,try another email", emailAddress));
        } catch (ResourceNotFoundException exception) {
            Teacher updatedTeacher = Teacher.builder()
                    .id(foundTeacher.getId())
                    .ucn(foundTeacher.getUcn())
                    .firstName(foundTeacher.getFirstName())
                    .lastName(foundTeacher.getLastName())
                    .emailAddress(emailAddress)
                    .telephoneNumber(foundTeacher.getTelephoneNumber())
                    .subjects(foundTeacher.getSubjects())
                    .build();
            return teacherRepository.save(updatedTeacher);
        }

    }

    @Override
    public Teacher updateTeacherTelephoneNumber(String ucn, String telephoneNumber) {
        Teacher foundTeacher = findByUcn(ucn);
        try {
            findByTelephoneNumber(telephoneNumber);
            throw new DuplicateRecordException(String.format("Teacher with %s tel. number, already exist,try another t.number", telephoneNumber));
        } catch (ResourceNotFoundException exception) {
            Teacher updatedTeacher = Teacher.builder()
                    .id(foundTeacher.getId())
                    .ucn(foundTeacher.getUcn())
                    .firstName(foundTeacher.getFirstName())
                    .lastName(foundTeacher.getLastName())
                    .emailAddress(foundTeacher.getEmailAddress())
                    .telephoneNumber(telephoneNumber)
                    .subjects(foundTeacher.getSubjects())
                    .build();
            return teacherRepository.save(updatedTeacher);
        }

    }

    @Override
    public void delete(String ucn) {
        Teacher foundTeacher = findByUcn(ucn);
        teacherRepository.deleteById(foundTeacher.getId());
    }

    @Override
    public Teacher findByUcn(String ucn) {
        return teacherRepository.findByUcn(ucn)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Teacher with %s ucn, is not exist", ucn)));
    }

    @Override
    public Teacher findByTelephoneNumber(String telephoneNumber) {
        return teacherRepository.findByTelephoneNumber(telephoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("There are no teacher whit %s number", telephoneNumber)));
    }

    @Override
    public Teacher findByEmailAddress(String emailAddress) {
        return teacherRepository.findByEmailAddress(emailAddress)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("There are no teacher whit %s email", emailAddress)));
    }

    // TODO: HERE!
    @Override
    public Set<Teacher> findByFirstName(String firstName) {
//
//        Set<Teacher> teachers = new HashSet<>();
//        teachers.stream().map( teacherRepository.findByFirstName(firstName)
//        ).collect(Collectors.toSet());

//                addAll(teacherRepository.findByFirstName(firstName).orElseThrow(() ->
//                new ResourceNotFoundException(String.format("Teacher whit first name %s, not found", firstName))));
//        return teachers;
        return null;
    }


    //TODO: need to config exception
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
