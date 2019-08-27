package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.dto.MedicineDto;

import java.util.List;

public interface MedicineService {

    List<MedicineDto> listAllMedicine();

    MedicineDto save(MedicineDto medicineDto);

    MedicineDto getById(Long id);

    void delete(long id);
}
