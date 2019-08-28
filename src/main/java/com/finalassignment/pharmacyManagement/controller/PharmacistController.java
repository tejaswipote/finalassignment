package com.finalassignment.pharmacyManagement.controller;


import com.finalassignment.pharmacyManagement.dto.PharmacistDto;
import com.finalassignment.pharmacyManagement.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class PharmacistController {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private PharmacistService pharmacistService;

    //Returns the list of all Pharmacist
    @GetMapping("/allPharmacist")
    public ResponseEntity<List> findAllPharmacist() {
        LOGGER.log(Level.INFO, "retriving all pharmacist");

        return ResponseEntity.ok(pharmacistService.listAllPharmacist());
    }

    //Return a pharmacist for given id
    @GetMapping("/getPharmacist/{pharmacistId}")
    public PharmacistDto getPharmacist(@PathVariable Long pharmacistId) {
        LOGGER.log(Level.INFO, "getting a pharmacist  details for pharmacistid "+ pharmacistId);

        return pharmacistService.getById(pharmacistId);
    }

    //delete pharmacist for given id
    @DeleteMapping(value = "/deletePharmacist/{id}")
    public ResponseEntity<Long> deletePharmacist(@PathVariable Long id) {
        LOGGER.log(Level.INFO, "deleting a sale  details for id "+ id);

        pharmacistService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //adding a new pharmacist
    @PostMapping("/addPharmacist")
    public ResponseEntity<PharmacistDto> addPharmacist(@RequestBody PharmacistDto pharmacistDto) {
        LOGGER.log(Level.INFO, "Pharmacist added");
        PharmacistDto addPharmacist = pharmacistService.save(pharmacistDto);
        return new ResponseEntity(addPharmacist, new HttpHeaders(), HttpStatus.OK);
    }


}