package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.model.Sale;

import java.util.List;

public interface SaleService {

    List<Sale> listAllSales();
    Sale saveSale(Sale sale);
    Sale getById(Long id);
}



