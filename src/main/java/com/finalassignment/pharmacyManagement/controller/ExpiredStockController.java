package com.finalassignment.pharmacyManagement.controller;


import com.finalassignment.pharmacyManagement.model.ExpiredStock;
import com.finalassignment.pharmacyManagement.service.ExpiredStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpiredStockController {

    @Autowired
    private ExpiredStockService expiredStockService;


    @GetMapping("/allExpired")
    public List<ExpiredStock> findAll() {

        return expiredStockService.listAllStock();
    }

    @DeleteMapping(value = "/deleteExStock/{id}")
    public ResponseEntity<Long> deleteExStock(@PathVariable Long id) {


        expiredStockService.delete(id);


        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
