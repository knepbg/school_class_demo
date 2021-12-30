package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Subject;
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
    }

    @Override
    public Teacher updateTeacherSubjects(String ucn, String subjectName) {

        Subject foundSubject = subjectService.findBySubjectName(subjectName);
        Teacher foundTeacher = findByUcn(ucn);

        Set<Subject> subjectSet = foundTeacher.getSubjects()
                .stream()
                .map( subject ->
                        subjectService.save(foundSubject))
                .collect(Collectors.toSet());

        Teacher updatedTeacher = Teacher.builder()
                .id(foundTeacher.getId())
                .firstName(foundTeacher.getFirstName())
                .lastName(foundTeacher.getLastName())
                .ucn(foundTeacher.getUcn())
                .emailAddress(foundTeacher.getEmailAddress())
                .telephoneNumber(foundTeacher.getTelephoneNumber())
                .subjects(subjectSet)
                .build();
        return teacherRepository.save(updatedTeacher);
    }

    @Override
    public Teacher updateTeacherEmailAddress(String ucn, String emailAddress) {
        Teacher foundTeacher = findByUcn(ucn);
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

    @Override
    public Teacher updateTeacherTelephoneNumber(String ucn, String telephoneNumber) {
        Teacher foundTeacher = findByUcn(ucn);
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


    @Override
    public void delete(String ucn) {
        Teacher foundTeacher = findByUcn(ucn);
        teacherRepository.deleteById(foundTeacher.getId());
    }

    //TODO: need to config exception
    @Override
    public Teacher findByUcn(String ucn) {
        return teacherRepository.findByUcn(ucn)
                .orElseThrow(IllegalAccessError::new);
    }

    //TODO:  need to config exception
    @Override
    public Teacher findByTelephoneNumber(String telephoneNumber) {
        return teacherRepository.findByTelephoneNumber(telephoneNumber)
                .orElseThrow(IllegalArgumentException::new);
    }

    //TODO: need to config exception
    @Override
    public Teacher findByEmailAddress(String emailAddress) {
        return teacherRepository.findByEmailAddress(emailAddress)
                .orElseThrow(IllegalArgumentException::new);
    }

    //TODO: need to config exception
    @Override
    public Set<Teacher> findByFirstName(String firstName) {
        SortedSet<Teacher> teachers = new TreeSet<>(Comparator
                .comparing(Teacher::getFirstName));
        teachers.addAll(teacherRepository.findByFirstName(firstName));
        return teachers;
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
