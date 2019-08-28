package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.ExPharmacistDto;
import com.finalassignment.pharmacyManagement.service.ExPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ExPharmacistController {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private ExPharmacistService exPharmacistService;

    //Returns the list of all EXPharmacist
    @GetMapping("/exPharmacist")
    public ResponseEntity<List> findAllExPharmacist() {
        LOGGER.log(Level.INFO, "getting all ExPharmacist s");

        return ResponseEntity.ok(exPharmacistService.listAllExPharmacist());
    }

    //Returns a EXPharmacist of given Id
    @GetMapping("/getExPharmacist/{exId}")
    public ExPharmacistDto getById(@PathVariable Long exId) {
        LOGGER.log(Level.INFO, "getting  ExpirdStock of id "+exId);

        return exPharmacistService.getById(exId);
    }
}
