package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.SaleDto;
import com.finalassignment.pharmacyManagement.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    /**
     * @return all sales till the date
     */
    @GetMapping("/allSales")
    public ResponseEntity<List> findAllSales() {
        log.info("retrieving all sales");
        return ResponseEntity.ok(saleService.listAllSales());
    }


    /**
     * @param saleId
     * @return details of sale for given id
     */
    @GetMapping("/getSale/{saleId}")
    public SaleDto getSale(@PathVariable Long saleId) {
        log.info("getting a sale  details for saleId " + saleId);
        return saleService.getById(saleId);
    }

    /**
     * Makes a new sale
     *
     * @param saleDto
     * @return
     */
    @PostMapping("/addSale")
    public ResponseEntity<SaleDto> addSale(@RequestBody SaleDto saleDto) {
        log.info("sale added...");
        SaleDto addsale = saleService.saveSale(saleDto);


        return new ResponseEntity(addsale, new HttpHeaders(), HttpStatus.OK);

    }

}
