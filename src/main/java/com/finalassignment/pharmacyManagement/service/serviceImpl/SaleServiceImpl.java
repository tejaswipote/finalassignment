package com.finalassignment.pharmacyManagement.service.serviceImpl;

import com.finalassignment.pharmacyManagement.ExceptionHandling.MedicineNotFoundException;
import com.finalassignment.pharmacyManagement.ExceptionHandling.OutOfStockException;
import com.finalassignment.pharmacyManagement.ExceptionHandling.SaleNotFoundException;
import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.model.Sale;
import com.finalassignment.pharmacyManagement.repository.SaleRepository;
import com.finalassignment.pharmacyManagement.service.MedicineService;
import com.finalassignment.pharmacyManagement.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private MedicineService medicineService;
@Override
    public List<Sale> listAllSales() {
        return saleRepository.findAll();
    }
@Override
    public Sale saveSale(Sale sale) {

        Long total = 0L;
        List<Medicine> medicines = sale.getMedicines();
        for (Medicine medicine : medicines) {
            Long count = medicine.getCount();

            Medicine soldMedicine = medicineService.getById(medicine.getMedicineId());
 if(count>soldMedicine.getQuantity())
 {
     throw new OutOfStockException(count);
 }
            soldMedicine.setQuantity(soldMedicine.getQuantity() - count);
            medicineService.save(soldMedicine);
            total += count * soldMedicine.getSellingPrice();
        }

        sale.setTotal(total);


        return saleRepository.save(sale);

    }
@Override
    public Sale getById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new SaleNotFoundException(id));
    }


}