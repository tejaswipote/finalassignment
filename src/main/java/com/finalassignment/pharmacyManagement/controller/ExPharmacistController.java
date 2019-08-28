package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.ExPharmacistDto;
import com.finalassignment.pharmacyManagement.service.ExPharmacistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ExPharmacistController {

    @Autowired
    private ExPharmacistService exPharmacistService;


    /**
     * @return list of all EXPharmacist
     */
    @GetMapping("/exPharmacist")
    public ResponseEntity<List> findAllExPharmacist() {
        log.info("getting all ExPharmacist s");

        return ResponseEntity.ok(exPharmacistService.listAllExPharmacist());
    }


    /**
     * @param exId
     * @return a EXPharmacist of given Id
     */
    @GetMapping("/getExPharmacist/{exId}")
    public ExPharmacistDto getById(@PathVariable Long exId) {
        log.info("getting  ExpirdStock of id " + exId);

        return exPharmacistService.getById(exId);
    }
}
