package com.schoolclass.demo.controller;

import com.schoolclass.demo.converter.GreatConverter;
import com.schoolclass.demo.dto.GreatDto;
import com.schoolclass.demo.model.Great;
import com.schoolclass.demo.service.GreatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/greats")
public class GreatController {

    private final GreatService greatService;
    private final GreatConverter greatConverter;

    public GreatController(GreatService greatService, GreatConverter greatConverter) {
        this.greatService = greatService;
        this.greatConverter = greatConverter;
    }

    @GetMapping
    public ResponseEntity<Set<GreatDto>> findAll() {
        Set<Great> foundGreats = greatService.findAll();
        Set<GreatDto> greatResponse = new TreeSet<>(Comparator.comparing(GreatDto::getGreatValue));
        greatResponse.addAll(foundGreats.stream()
                .map(greatConverter::toGreatDto)
                .collect(Collectors.toSet()));
        return ResponseEntity.ok(greatResponse);
    }

    @PostMapping
    public ResponseEntity<GreatDto> save(@RequestBody @Valid GreatDto greatDto) {
        Great greatForSave = greatConverter.toGreat(greatDto);
        Great savedGreat = greatService.save(greatForSave);
        return ResponseEntity.ok(greatConverter.toGreatDto(savedGreat));
    }

    @DeleteMapping
    public ResponseEntity<GreatDto> deleteAll() {
        greatService.deleteAll();
        return ResponseEntity.ok(GreatDto.builder().build());
    }
}
