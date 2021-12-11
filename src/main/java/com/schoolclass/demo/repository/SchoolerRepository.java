package com.schoolclass.demo.repository;

import com.schoolclass.demo.model.Schooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolerRepository extends JpaRepository<Schooler, Long> {
}
