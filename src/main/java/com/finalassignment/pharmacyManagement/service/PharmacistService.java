package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.model.Pharmacist;

import java.util.List;

public interface PharmacistService {
    List<Pharmacist> listAllPharmacist();
    void save(Pharmacist pharmacist);
    void delete(long id);
    Pharmacist getById(Long id);
}
