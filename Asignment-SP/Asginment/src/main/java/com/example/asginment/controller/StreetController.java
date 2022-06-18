package com.example.asginment.controller;

import com.example.asginment.entity.District;
import com.example.asginment.entity.Street;
import com.example.asginment.repository.DistrictRepository;
import com.example.asginment.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/v1/streets")
public class StreetController {
    @Autowired
    private StreetRepository streetRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Street>> getList() {
        return ResponseEntity.ok(streetRepository.findAll());
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> create(@RequestBody Street street) {
        return ResponseEntity.ok(streetRepository.save(street));
    }
}
