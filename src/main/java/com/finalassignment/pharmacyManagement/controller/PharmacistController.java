package com.finalassignment.pharmacyManagement.controller;


import com.finalassignment.pharmacyManagement.model.Pharmacist;
import com.finalassignment.pharmacyManagement.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping("/allPharmacist")
    public List<Pharmacist> findAllPharmacist() {
        return pharmacistService.listAllPharmacist();
    }


    @GetMapping("/getPharmacist/{pharmacistId}")
    public Pharmacist getPharmacist(@PathVariable Long pharmacistId) {
        return pharmacistService.getById(pharmacistId);
    }

    @DeleteMapping(value = "/deletePharmacist/{id}")
    public ResponseEntity<Long> deletePharmacist(@PathVariable Long id) {


        pharmacistService.delete(id);


        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @PostMapping("/addPharmacist")
    public String addPharmacist(@RequestBody Pharmacist pharmacist) {


        pharmacistService.save(pharmacist);
        return "Pharmacist Successfully added";
    }


}