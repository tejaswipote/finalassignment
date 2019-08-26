package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.model.ExPharmacist;
import com.finalassignment.pharmacyManagement.model.Pharmacist;

import java.util.List;

public interface ExPharmacistService {
    List<ExPharmacist> listAllExPharmacist();
    ExPharmacist getById(Long id);
    void movetoExPharmacist(Pharmacist pharmacist);
    void deleteExPharmacist(long id);
}
