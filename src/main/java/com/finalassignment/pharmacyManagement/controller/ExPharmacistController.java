package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.model.ExPharmacist;
import com.finalassignment.pharmacyManagement.service.ExPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExPharmacistController {

    @Autowired
    private ExPharmacistService exPharmacistService;

    @GetMapping("/exPharmacist")
    public List<ExPharmacist> findAllExPharmacist() {
        return exPharmacistService.listAllExPharmacist();
    }


    @GetMapping("/getExPharmacist/{exId}")
    public ExPharmacist getById(@PathVariable Long exId) {
        return exPharmacistService.getById(exId);
    }
}
