package com.finalassignment.pharmacyManagement.service;


import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;


    @Autowired
    private ExpiredStockService expiredStockService;

    public List<Medicine> listAllMedicine() {
        List<Medicine> list = medicineRepository.findAll();
        list.forEach(medicine -> {
            if (medicine.getExpiryDate().compareTo(new Date()) < 0) {
                expiredStockService.movetoExpired(medicine);
                medicineRepository.delete(medicine);
            }

        });
        return medicineRepository.findAll();
    }

    public void save(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public Medicine getById(Long id) {
        return medicineRepository.findById(id).get();
    }



    public void delete(long id) {
        medicineRepository.deleteById(id);
    }
}
