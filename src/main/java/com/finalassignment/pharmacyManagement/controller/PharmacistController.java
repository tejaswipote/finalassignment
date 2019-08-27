package com.finalassignment.pharmacyManagement.controller;


import com.finalassignment.pharmacyManagement.dto.PharmacistDto;
import com.finalassignment.pharmacyManagement.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;


    @GetMapping("/allPharmacist")
    public ResponseEntity<List> findAllPharmacist() {
        return ResponseEntity.ok(pharmacistService.listAllPharmacist());
    }


    @GetMapping("/getPharmacist/{pharmacistId}")
    public PharmacistDto getPharmacist(@PathVariable Long pharmacistId) {
        return pharmacistService.getById(pharmacistId);
    }

    @DeleteMapping(value = "/deletePharmacist/{id}")
    public ResponseEntity<Long> deletePharmacist(@PathVariable Long id) {


        pharmacistService.delete(id);


        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @PostMapping("/addPharmacist")
    public ResponseEntity<PharmacistDto> addPharmacist(@RequestBody PharmacistDto pharmacistDto) {


        PharmacistDto addPharmacist = pharmacistService.save(pharmacistDto);
        return new ResponseEntity(addPharmacist, new HttpHeaders(), HttpStatus.OK);
    }


}