package com.schoolclass.demo.repository;

import com.schoolclass.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByUcn(String ucn);

    Optional<Teacher> findByTelephoneNumber(String telephoneNumber);

    Optional<Teacher> findByEmailAddress(String emailAddress);

    List<Teacher> findByFirstName(String firstName);

    List<Teacher> findByLastName(String lastName);
}
