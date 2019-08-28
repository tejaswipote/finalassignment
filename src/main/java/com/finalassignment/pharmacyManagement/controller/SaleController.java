package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.SaleDto;
import com.finalassignment.pharmacyManagement.model.Sale;
import com.finalassignment.pharmacyManagement.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class SaleController {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private SaleService saleService;
//Returns all sales till the date
    @GetMapping("/allSales")
    public ResponseEntity<List> findAllSales()
    {
        LOGGER.log(Level.INFO, "retrieving all sales");
        return ResponseEntity.ok(saleService.listAllSales());
    }

//gives details of sale for given id
    @GetMapping("/getSale/{saleId}")
    public SaleDto getSale(@PathVariable Long saleId) {
        LOGGER.log(Level.INFO, "getting a sale  details for saleId "+ saleId);
        return saleService.getById(saleId);
    }

//Makes a new sale
    @PostMapping("/addSale")
    public ResponseEntity<SaleDto> addSale(@RequestBody SaleDto saleDto) {
        LOGGER.log(Level.INFO, "sale added...");
        SaleDto addsale = saleService.saveSale(saleDto);

        return new ResponseEntity(addsale, new HttpHeaders(), HttpStatus.OK);

    }

}
