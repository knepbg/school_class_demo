package com.schoolclass.demo.repository;

import com.schoolclass.demo.model.Schooler;
import com.schoolclass.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByUcn (String ucn);

    Optional<Teacher> findByTelephoneNumber(String telephoneNumber);

    Optional<Teacher> findByEmailAddress(String emailAddress);

    Set<Teacher> findByFirstName(String firstName);

    Set<Teacher> findByLastName(String lastName);
}
