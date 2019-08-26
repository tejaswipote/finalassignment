package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.model.ExpiredStock;
import com.finalassignment.pharmacyManagement.model.Medicine;

import java.util.List;

public interface ExpiredStockService {
    List<ExpiredStock> listAllStock();
    void movetoExpired(Medicine medicine);
    void delete(long id);


}
