package com.schoolclass.demo.repository;

import com.schoolclass.demo.model.Great;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreatRepository extends JpaRepository<Great, Long> {


}
