package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Great;
import com.schoolclass.demo.repository.GreatRepository;
import com.schoolclass.demo.service.GreatService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GreatServiceImpl implements GreatService {

    private final GreatRepository greatRepository;

    public GreatServiceImpl(GreatRepository greatRepository) {
        this.greatRepository = greatRepository;
    }

    @Override
    public Set<Great> findAll() {
        return new HashSet<Great>(greatRepository.findAll());
    }

    @Override
    public Great save(Great great) {
        return greatRepository.save(great);
    }

    @Override
    public void deleteAll() {
        greatRepository.deleteAll();
    }
}
