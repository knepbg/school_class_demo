package com.schoolclass.demo.repository;

import com.schoolclass.demo.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

    Set<ClassRoom> findByClassRoomName(String classRoomName);
}
