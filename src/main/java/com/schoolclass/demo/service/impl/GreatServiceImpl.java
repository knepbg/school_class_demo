package com.schoolclass.demo.service.impl;

import com.schoolclass.demo.model.Great;
import com.schoolclass.demo.repository.GreatRepository;
import com.schoolclass.demo.service.GreatService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class GreatServiceImpl implements GreatService {

    private final GreatRepository greatRepository;

    public GreatServiceImpl(GreatRepository greatRepository) {
        this.greatRepository = greatRepository;
    }

    @Override
    public Set<Great> findAll() {
        SortedSet<Great> greats = new TreeSet<>(Comparator.comparing(Great::getGreatValue));
        greats.addAll(greatRepository.findAll());
        return greats;
    }

    @Override
    public Great save(Great great) {
        return greatRepository.save(great);
    }
}
