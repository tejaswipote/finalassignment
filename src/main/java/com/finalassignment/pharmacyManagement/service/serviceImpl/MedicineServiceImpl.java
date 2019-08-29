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


    /**
     * This is entity converter method which changes entity from Medicine to MedicineDto
     * @param medicine
     * @return
     */
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


    /**
     *This is entity converter method which changes entity from MedicineDto to Medicine
     * @param medicineDto
     * @return
     */

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

    /**
     *
     * @return list of all medicine available
     */
    @Override
    public List<MedicineDto> listAllMedicine() {
        List<Medicine> list = medicineRepository.findAll();
        List<MedicineDto> medicineDtos = null;
        //Check for expiryDate of medicine
        list.forEach(medicine -> {
            if (medicine.getExpiryDate().compareTo(new Date()) < 0) {

                //if medicine has expired then it removes from medicine and insert into expired stock
                expiredStockService.movetoExpired(medicine);
                medicineRepository.delete(medicine);
            }

        });
        if (!CollectionUtils.isEmpty(list)) {
            medicineDtos = new ArrayList<>();
            //loop through all Medicine in list
            for (Medicine medicine : list) {
                MedicineDto medicineDto = fromMedicine(medicine);
                medicineDtos.add(medicineDto);
            }
        }
        return medicineDtos;


    }

    /**
     * save Medicine into database
     * @param medicineDto
     * @return
     */
    @Override
    public Medicine save(MedicineDto medicineDto) {
        Medicine medicine = medicineRepository.save(fromMedicineDto(medicineDto));
        return medicine;
    }


    /**
     *
     * @param id
     * @return medicine for given id
     */
    @Override
    public MedicineDto getById(Long id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new MedicineNotFoundException(id));
        MedicineDto medicineDto = fromMedicine(medicine);
        return medicineDto;
    }

    /**
     * delete medicine for given id
     * @param id
     */
    @Override
    public void delete(long id) {
        medicineRepository.deleteById(id);
    }
}
