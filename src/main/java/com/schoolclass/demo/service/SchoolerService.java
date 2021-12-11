package com.schoolclass.demo.service;

import com.schoolclass.demo.model.Schooler;

import java.util.Set;

public interface SchoolerService {

    Schooler save(Schooler schooler);

    Schooler findByNumberInClass(String numberInClass);

    Set<Schooler> findByFirstName(String firstName);

    Set<Schooler> findByLastName(String lastName);

    Set<Schooler> findAll();

    Schooler update(Schooler schooler, String numberInClass);

    void delete(String numberInClass);



}
