package com.finalassignment.pharmacyManagement.service.serviceImpl;


import com.finalassignment.pharmacyManagement.dto.ExpiredStockDto;
import com.finalassignment.pharmacyManagement.model.ExpiredStock;
import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.repository.ExpiredStockRepository;
import com.finalassignment.pharmacyManagement.service.ExpiredStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExpiredStockServiceImpl implements ExpiredStockService {

    @Autowired
    private ExpiredStockRepository expiredStockRepository;

    private static ExpiredStockDto fromExStockDto(final ExpiredStock expiredStock) {

        ExpiredStockDto expiredStockDto = new ExpiredStockDto();
        expiredStockDto.setMedicineId(expiredStock.getMedicineId());
        expiredStockDto.setMedicineName(expiredStock.getMedicineName());
        expiredStockDto.setCategory(expiredStock.getCategory());
        expiredStockDto.setCostPrice(expiredStock.getCostPrice());
        expiredStockDto.setManufacturingDate(expiredStock.getManufacturingDate());
        expiredStockDto.setExpiryDate(expiredStock.getExpiryDate());
        expiredStockDto.setQuantity(expiredStock.getQuantity());

        return expiredStockDto;
    }

    private static ExpiredStock fromExStock(final ExpiredStockDto expiredStockDto) {

        ExpiredStock expiredStock = new ExpiredStock();
        expiredStock.setMedicineId(expiredStockDto.getMedicineId());
        expiredStock.setMedicineName(expiredStockDto.getMedicineName());
        expiredStock.setCategory(expiredStockDto.getCategory());
        expiredStock.setCostPrice(expiredStockDto.getCostPrice());
        expiredStock.setManufacturingDate(expiredStockDto.getManufacturingDate());
        expiredStock.setExpiryDate(expiredStockDto.getExpiryDate());
        expiredStock.setQuantity(expiredStockDto.getQuantity());

        return expiredStock;
    }


    @Override
    public List<ExpiredStockDto> listAllStock() {

        List<ExpiredStock> expiredStocks = expiredStockRepository.findAll();
        List<ExpiredStockDto> expiredStockDtos = null;
        if (!CollectionUtils.isEmpty(expiredStocks)) {
            expiredStockDtos = new ArrayList<>();
            for (ExpiredStock expiredStock : expiredStocks) {
                ExpiredStockDto expiredStockDto = fromExStockDto(expiredStock);
                expiredStockDtos.add(expiredStockDto);
            }
        }
        return expiredStockDtos;
    }

    @Override
    public void movetoExpired(Medicine medicine) {
        ExpiredStock expiredStock = new ExpiredStock();
        expiredStock.setMedicineName(medicine.getMedicineName());
        expiredStock.setCategory(medicine.getCategory());
        expiredStock.setCostPrice(medicine.getCostPrice());
        expiredStock.setQuantity(medicine.getQuantity());
        expiredStock.setManufacturingDate(medicine.getManufacturingDate());
        expiredStock.setExpiryDate(medicine.getExpiryDate());
        expiredStockRepository.save(expiredStock);
    }

    @Override
    public void delete(long id) {
        expiredStockRepository.deleteById(id);
    }

}
