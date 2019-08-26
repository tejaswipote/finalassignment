package com.finalassignment.pharmacyManagement.service.serviceImpl;


import com.finalassignment.pharmacyManagement.ExceptionHandling.MedicineNotFoundException;
import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.repository.MedicineRepository;
import com.finalassignment.pharmacyManagement.service.MedicineService;
import com.finalassignment.pharmacyManagement.service.serviceImpl.ExpiredStockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;


    @Autowired
    private ExpiredStockServiceImpl expiredStockServiceImpl;
    @Override
    public List<Medicine> listAllMedicine() {
        List<Medicine> list = medicineRepository.findAll();
        list.forEach(medicine -> {
            if (medicine.getExpiryDate().compareTo(new Date()) < 0) {
                expiredStockServiceImpl.movetoExpired(medicine);
                medicineRepository.delete(medicine);
            }

        });
        return medicineRepository.findAll();
    }
    @Override
    public void save(Medicine medicine) {
        medicineRepository.save(medicine);
    }
    @Override
    public Medicine getById(Long id) {
        return medicineRepository.findById(id).orElseThrow(() -> new MedicineNotFoundException(id));

    }


    @Override
    public void delete(long id) {
        medicineRepository.deleteById(id);
    }
}
