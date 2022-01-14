package com.schoolclass.demo.service;

import com.schoolclass.demo.model.Great;

import java.util.Set;

public interface GreatService {

    Set<Great> findAll();

    Great save(Great great);

    void deleteAll ();


}
