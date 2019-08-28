package com.finalassignment.pharmacyManagement.controller;


import com.finalassignment.pharmacyManagement.dto.PharmacistDto;
import com.finalassignment.pharmacyManagement.service.PharmacistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@Slf4j
@RestController
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;

    /**
     *
     * @return list of all Pharmacist
     */
    @GetMapping("/allPharmacist")
    public ResponseEntity<List> findAllPharmacist() {
        log.info("retriving all pharmacist");

        return ResponseEntity.ok(pharmacistService.listAllPharmacist());
    }


    /**
     *
     * @param pharmacistId
     * @return a pharmacist for given id
     */
    @GetMapping("/getPharmacist/{pharmacistId}")
    public PharmacistDto getPharmacist(@PathVariable Long pharmacistId) {
        log.info("getting a pharmacist  details for pharmacistid "+ pharmacistId);

        return pharmacistService.getById(pharmacistId);
    }



    /**
     * delete pharmacist for given id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deletePharmacist/{id}")
    public ResponseEntity<Long> deletePharmacist(@PathVariable Long id) {
        log.info("deleting a sale  details for id "+ id);

        pharmacistService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    /**
     * adding a new pharmacist
     * @param pharmacistDto
     * @return
     */
    @PostMapping("/addPharmacist")
    public ResponseEntity<PharmacistDto> addPharmacist(@RequestBody PharmacistDto pharmacistDto) {
        log.info("Pharmacist added");
        PharmacistDto addPharmacist = pharmacistService.save(pharmacistDto);
        return new ResponseEntity(addPharmacist, new HttpHeaders(), HttpStatus.OK);
    }


}