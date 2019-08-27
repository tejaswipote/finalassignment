package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.dto.SaleDto;
import com.finalassignment.pharmacyManagement.model.Sale;

import java.util.List;

public interface SaleService {
    Sale getById(Long id);
    SaleDto addSale(SaleDto saleDto);

    List<Sale> listAllSales();
    SaleDto saveSale(SaleDto saleDto);

}



