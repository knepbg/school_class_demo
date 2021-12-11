package com.schoolclass.demo.repository;

import com.schoolclass.demo.model.Schooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SchoolerRepository extends JpaRepository<Schooler, Long> {

    Optional<Schooler> findByNumberInClass(String numberInClass);

    Set<Schooler> findByFirstName(String firstName);

    Set<Schooler> findByLastName(String lastName);

}
