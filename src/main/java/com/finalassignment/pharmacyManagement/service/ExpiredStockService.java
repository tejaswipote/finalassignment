package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.ExceptionHandling.ExpiredStockNotFoundException;
import com.finalassignment.pharmacyManagement.model.ExpiredStock;
import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.repository.ExpiredStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExpiredStockService {

    @Autowired
    private ExpiredStockRepository expiredStockRepository;

    public List<ExpiredStock> listAllStock() {
        return expiredStockRepository.findAll();
    }


    public void movetoExpired(Medicine medicine) {
        ExpiredStock expiredStock = new ExpiredStock();
        expiredStock.setMedicineName(medicine.getMedicineName());
        expiredStock.setCategory(medicine.getCategory());
        expiredStock.setCostPrice(medicine.getCostPrice());
        expiredStock.setQuantity(medicine.getQuantity());
        expiredStock.setManufacturingDate(medicine.getManufacturingDate());
        expiredStock.setExpiryDate(medicine.getExpiryDate());
        expiredStockRepository.save(expiredStock);
    }

    public void delete(long id) {
        expiredStockRepository.deleteById(id);
    }

}
