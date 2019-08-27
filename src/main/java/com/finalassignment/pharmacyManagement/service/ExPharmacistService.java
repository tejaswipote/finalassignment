package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.dto.ExPharmacistDto;
import com.finalassignment.pharmacyManagement.model.Pharmacist;

import java.util.List;

public interface ExPharmacistService {
    List<ExPharmacistDto> listAllExPharmacist();

    ExPharmacistDto getById(Long id);

    void movetoExPharmacist(Pharmacist pharmacist);

    void deleteExPharmacist(long id);
}
