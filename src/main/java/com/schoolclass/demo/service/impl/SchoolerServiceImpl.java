package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Schooler;
import com.schoolclass.demo.repository.SchoolerRepository;
import com.schoolclass.demo.service.SchoolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class SchoolerServiceImpl implements SchoolerService {

    private final SchoolerRepository schoolerRepository;

    @Autowired
    public SchoolerServiceImpl(SchoolerRepository schoolerRepository) {
        this.schoolerRepository = schoolerRepository;
    }


    @Override
    public Schooler save(Schooler schooler) {
        return schoolerRepository.save(schooler);
    }


    //TODO: need to config exceptions
    @Override
    public Schooler findByNumberInClass(String numberInClass) {
        return schoolerRepository.findByNumberInClass(numberInClass)
                .orElseThrow(IllegalArgumentException::new);
    }


    //TODO: need to config exception
    @Override
    public Set<Schooler> findByFirstName(String firstName) {
        SortedSet<Schooler> schoolers = new TreeSet<>(Comparator
                .comparing(Schooler::getFirstName));
        schoolers.addAll(schoolerRepository.findByFirstName(firstName));
        return schoolers;
    }

    //TODO: need to config exception
    @Override
    public Set<Schooler> findByLastName(String lastName) {
        SortedSet<Schooler> schoolers = new TreeSet<>(Comparator
                .comparing(Schooler::getLastName));
        schoolers.addAll(schoolerRepository.findByLastName(lastName));
        return schoolers;
    }

    @Override
    public Set<Schooler> findAll() {
        SortedSet<Schooler> schoolers = new TreeSet<>(Comparator
                .comparing(Schooler::getId));
        schoolers.addAll(schoolerRepository.findAll());
        return schoolers;
    }

    // updating number in class in case there are new schooler came in the middle of the studying year
    @Override
    public Schooler update(Schooler schooler, String numberInClass) {
        Schooler foundedSchooler = findByNumberInClass(numberInClass);
        Schooler updatedSchooler = Schooler.builder()
                .id(foundedSchooler.getId())
                .firstName(foundedSchooler.getFirstName())
                .lastName(foundedSchooler.getLastName())
                .numberInClass(schooler.getNumberInClass())
                .build();
        return schoolerRepository.save(updatedSchooler);
    }

    //TODO: need to config exceptions
    @Override
    public void delete(String numberInClass) {
        Schooler foundedSchooler = schoolerRepository
                .findByNumberInClass(numberInClass)
                .orElseThrow(IllegalAccessError::new);
        schoolerRepository.deleteById(foundedSchooler.getId());

    }
}
