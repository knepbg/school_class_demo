package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Schooler;
import com.schoolclass.demo.repository.SchoolerRepository;
import com.schoolclass.demo.service.SchoolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SchoolerServiceImpl implements SchoolerService {

    private final SchoolerRepository schoolerRepository;

    @Autowired
    public SchoolerServiceImpl(SchoolerRepository schoolerRepository) {
        this.schoolerRepository = schoolerRepository;
    }

    @Override
    public Schooler save(Schooler schooler) {
        return null;
    }

    @Override
    public Schooler findByNumberInClass(String numberInClass) {
        return null;
    }

    @Override
    public Set<Schooler> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public Set<Schooler> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Schooler> findAll() {
        return null;
    }

    @Override
    public Schooler update(Schooler schooler, String numberInClass) {
        return null;
    }

    @Override
    public void delete(String numberInClass) {

    }
}
