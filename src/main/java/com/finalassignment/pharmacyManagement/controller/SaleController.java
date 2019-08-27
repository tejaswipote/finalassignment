package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.SaleDto;
import com.finalassignment.pharmacyManagement.model.Sale;
import com.finalassignment.pharmacyManagement.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/allSales")
    public List<Sale> findAllSales() {
        return saleService.listAllSales();
    }


    @GetMapping("/getSale/{saleId}")
    public Sale getSale(@PathVariable Long saleId) {
        return saleService.getById(saleId);
    }


    @PostMapping("/addSale")
    public SaleDto addSale(@RequestBody SaleDto saleDto) {
        return saleService.saveSale(saleDto);

    }

}
