package com.finalassignment.pharmacyManagement.service.serviceImpl;


import com.finalassignment.pharmacyManagement.exceptionhandling.PharmacistNotFoundException;
import com.finalassignment.pharmacyManagement.model.Pharmacist;
import com.finalassignment.pharmacyManagement.repository.PharmacistRepository;
import com.finalassignment.pharmacyManagement.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PharmacistServiceImpl implements PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private ExPharmacistServiceImpl exPharmacistServiceImpl;

    @Override
    public List<Pharmacist> listAllPharmacist() {

        return pharmacistRepository.findAll();
    }
    @Override
    public void save(Pharmacist pharmacist) {
        pharmacistRepository.save(pharmacist);
    }
    @Override
    public Pharmacist getById(Long id) {
        return pharmacistRepository.findById(id).orElseThrow(() -> new PharmacistNotFoundException(id));
    }

    @Override
    public void delete(long id) {
        Pharmacist pharmacist = pharmacistRepository.findById(id).get();
        exPharmacistServiceImpl.movetoExPharmacist(pharmacist);
        pharmacistRepository.deleteById(id);
    }
}

