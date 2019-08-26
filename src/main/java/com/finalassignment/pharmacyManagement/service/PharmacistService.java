package com.finalassignment.pharmacyManagement.service;


import com.finalassignment.pharmacyManagement.model.Pharmacist;
import com.finalassignment.pharmacyManagement.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private ExPharmacistService exPharmacistService;

    public List<Pharmacist> listAllPharmacist() {

        return pharmacistRepository.findAll();
    }

    public void save(Pharmacist pharmacist) {
        pharmacistRepository.save(pharmacist);
    }

    public Pharmacist getById(Long id) {
        return pharmacistRepository.findById(id).get();
    }


    public void delete(long id) {
        Pharmacist pharmacist = pharmacistRepository.findById(id).get();
        exPharmacistService.movetoExPharmacist(pharmacist);
        pharmacistRepository.deleteById(id);
    }
}

