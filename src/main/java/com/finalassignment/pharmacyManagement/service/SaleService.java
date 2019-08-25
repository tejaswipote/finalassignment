package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.model.Sale;
import com.finalassignment.pharmacyManagement.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> listAllSales() {
        return saleRepository.findAll();
    }

    public void save(Sale sale) {

        saleRepository.save(sale);
    }

    public Sale getById(Long id) {
        return saleRepository.findById(id).get();
    }



}
