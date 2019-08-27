package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.SaleDto;
import com.finalassignment.pharmacyManagement.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/allSales")
    public ResponseEntity<List> findAllSales() {
        return ResponseEntity.ok(saleService.listAllSales());
    }


    @GetMapping("/getSale/{saleId}")
    public SaleDto getSale(@PathVariable Long saleId) {
        return saleService.getById(saleId);
    }


    @PostMapping("/addSale")
    public ResponseEntity<SaleDto> addSale(@RequestBody SaleDto saleDto) {
        SaleDto addsale = saleService.saveSale(saleDto);

        return new ResponseEntity(addsale, new HttpHeaders(), HttpStatus.OK);

    }

}
