package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.ExPharmacistDto;
import com.finalassignment.pharmacyManagement.service.ExPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExPharmacistController {

    @Autowired
    private ExPharmacistService exPharmacistService;

    @GetMapping("/exPharmacist")
    public ResponseEntity<List> findAllExPharmacist() {
        return ResponseEntity.ok(exPharmacistService.listAllExPharmacist());
    }


    @GetMapping("/getExPharmacist/{exId}")
    public ExPharmacistDto getById(@PathVariable Long exId) {
        return exPharmacistService.getById(exId);
    }
}
