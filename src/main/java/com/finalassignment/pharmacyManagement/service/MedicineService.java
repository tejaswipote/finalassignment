package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.model.Medicine;

import java.util.List;

public interface MedicineService {

    List<Medicine> listAllMedicine();
    void save(Medicine medicine);
    Medicine getById(Long id);
    void delete(long id);
}
