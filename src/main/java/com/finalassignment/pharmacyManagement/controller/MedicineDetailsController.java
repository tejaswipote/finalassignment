package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.model.MedicineDetailsToUser;
import com.finalassignment.pharmacyManagement.service.MedicineDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MedicineDetailsController {


    @Autowired
    private MedicineDetailsService medicineDetailsService;

    @GetMapping("/ListMedicine")
    public List<MedicineDetailsToUser> findAllMedicine() {
        return medicineDetailsService.listAllMedicine();
    }

}