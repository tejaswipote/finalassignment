package com.finalassignment.pharmacyManagement.service.serviceImpl;


import com.finalassignment.pharmacyManagement.model.ExpiredStock;
import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.repository.ExpiredStockRepository;
import com.finalassignment.pharmacyManagement.service.ExpiredStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExpiredStockServiceImpl implements ExpiredStockService {

    @Autowired
    private ExpiredStockRepository expiredStockRepository;
    @Override
    public List<ExpiredStock> listAllStock() {
        return expiredStockRepository.findAll();
    }

    @Override
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
    @Override
    public void delete(long id) {
        expiredStockRepository.deleteById(id);
    }

}
