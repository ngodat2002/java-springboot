package com.example.asginment.controller;

import com.example.asginment.entity.District;
import com.example.asginment.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/v1/districts")
public class DistrictController {
    @Autowired
    private DistrictRepository districtRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<District>> getList() {
        return ResponseEntity.ok(districtRepository.findAll());
    }

}
