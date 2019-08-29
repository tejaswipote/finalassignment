package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.dto.MedicineDto;
import com.finalassignment.pharmacyManagement.model.Medicine;

import java.util.List;

public interface MedicineService {

    List<MedicineDto> listAllMedicine();

    Medicine save(MedicineDto medicineDto);

    MedicineDto getById(Long id);

    void delete(long id);
}
