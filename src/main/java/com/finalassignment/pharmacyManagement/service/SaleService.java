package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.dto.SaleDto;

import java.util.List;

public interface SaleService {
    SaleDto getById(Long id);

    SaleDto addSale(SaleDto saleDto);

    List<SaleDto> listAllSales();

    SaleDto saveSale(SaleDto saleDto);

}



