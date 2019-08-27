package com.finalassignment.pharmacyManagement.service.serviceImpl;


import com.finalassignment.pharmacyManagement.dto.MedicineDto;
import com.finalassignment.pharmacyManagement.exceptionhandling.MedicineNotFoundException;
import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.repository.MedicineRepository;
import com.finalassignment.pharmacyManagement.service.ExpiredStockService;
import com.finalassignment.pharmacyManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;


    @Autowired
    private ExpiredStockService expiredStockService;


    private static MedicineDto fromMedicine(final Medicine medicine) {

        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setMedicineId(medicine.getMedicineId());
        medicineDto.setMedicineName(medicine.getMedicineName());
        medicineDto.setCategory(medicine.getCategory());
        medicineDto.setCostPrice(medicine.getCostPrice());
        medicineDto.setSellingPrice(medicine.getSellingPrice());
        medicineDto.setManufacturer(medicine.getManufacturer());
        medicineDto.setSellingPrice(medicine.getSellingPrice());
        medicineDto.setCount(medicine.getCount());
        medicineDto.setManufacturingDate(medicine.getManufacturingDate());
        medicineDto.setExpiryDate(medicine.getExpiryDate());
        medicineDto.setQuantity(medicine.getQuantity());

        return medicineDto;
    }

    private static Medicine fromMedicineDto(final MedicineDto medicineDto) {

        Medicine medicine = new Medicine();
        medicine.setMedicineId(medicineDto.getMedicineId());
        medicine.setMedicineName(medicineDto.getMedicineName());
        medicine.setCategory(medicineDto.getCategory());
        medicine.setCostPrice(medicineDto.getCostPrice());
        medicine.setSellingPrice(medicineDto.getSellingPrice());
        medicine.setManufacturer(medicineDto.getManufacturer());
        medicine.setSellingPrice(medicineDto.getSellingPrice());
        medicine.setCount(medicineDto.getCount());
        medicine.setManufacturingDate(medicineDto.getManufacturingDate());
        medicine.setExpiryDate(medicineDto.getExpiryDate());
        medicine.setQuantity(medicineDto.getQuantity());

        return medicine;
    }

    @Override
    public List<MedicineDto> listAllMedicine() {
        List<Medicine> list = medicineRepository.findAll();
        List<MedicineDto> medicineDtos = null;
        list.forEach(medicine -> {
            if (medicine.getExpiryDate().compareTo(new Date()) < 0) {
                expiredStockService.movetoExpired(medicine);
                medicineRepository.delete(medicine);
            }

        });
        if (!CollectionUtils.isEmpty(list)) {
            medicineDtos = new ArrayList<>();
            for (Medicine medicine : list) {
                MedicineDto medicineDto = fromMedicine(medicine);
                medicineDtos.add(medicineDto);
            }
        }
        return medicineDtos;


    }

    @Override
    public MedicineDto save(MedicineDto medicineDto) {
        Medicine medicine = medicineRepository.save(fromMedicineDto(medicineDto));
        return medicineDto;
    }

    @Override
    public MedicineDto getById(Long id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new MedicineNotFoundException(id));
        MedicineDto medicineDto = fromMedicine(medicine);
        return medicineDto;
    }


    @Override
    public void delete(long id) {
        medicineRepository.deleteById(id);
    }
}
