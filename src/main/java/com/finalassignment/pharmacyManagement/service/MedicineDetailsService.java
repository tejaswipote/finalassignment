package com.finalassignment.pharmacyManagement.service;

import com.finalassignment.pharmacyManagement.model.MedicineDetailsToUser;
import com.finalassignment.pharmacyManagement.repository.MedicineDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicineDetailsService {

    @Autowired
    private MedicineDetailsRepository medicineDetailsRepository;

    public List<MedicineDetailsToUser> listAllMedicine() {
        return medicineDetailsRepository.findAll();
    }


    public void save(MedicineDetailsToUser medicineDetailsToUser) {
        medicineDetailsRepository.save(medicineDetailsToUser);
    }
}
