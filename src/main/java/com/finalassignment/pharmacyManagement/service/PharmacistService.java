package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.dto.PharmacistDto;

import java.util.List;

public interface PharmacistService {
    List<PharmacistDto> listAllPharmacist();

    PharmacistDto save(PharmacistDto pharmacistDto);

    void delete(long id);

    PharmacistDto getById(Long id);
}
