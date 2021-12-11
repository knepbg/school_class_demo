package com.schoolclass.demo.repository;

import com.schoolclass.demo.model.Schooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SchoolerRepository extends JpaRepository<Schooler, Long> {

    Optional<Schooler> findByNumberInClass(@Param("numberInClass") String numberInClass);

    Set<Schooler> findByFirstName(@Param("firstName") String firstName);

    Set<Schooler> findByLastName(@Param("lastName") String lastName);

}
