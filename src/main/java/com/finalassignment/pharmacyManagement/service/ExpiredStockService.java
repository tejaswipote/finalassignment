package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.dto.ExpiredStockDto;
import com.finalassignment.pharmacyManagement.model.Medicine;

import java.util.List;

public interface ExpiredStockService {
    List<ExpiredStockDto> listAllStock();

    void movetoExpired(Medicine medicine);

    void delete(long id);


}
