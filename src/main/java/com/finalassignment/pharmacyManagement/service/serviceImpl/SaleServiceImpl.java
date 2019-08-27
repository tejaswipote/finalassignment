package com.finalassignment.pharmacyManagement.service.serviceImpl;

import com.finalassignment.pharmacyManagement.dto.SaleDto;
import com.finalassignment.pharmacyManagement.exceptionhandling.OutOfStockException;
import com.finalassignment.pharmacyManagement.exceptionhandling.SaleNotFoundException;
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


    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    private static SaleDto fromSale(final Sale sale) {

        SaleDto saleDto = new SaleDto();
        saleDto.setSaleId(sale.getSaleId());
        saleDto.setCustomerName(sale.getCustomerName());
        saleDto.setAddress(sale.getAddress());
        saleDto.setMedicines(sale.getMedicines());
        saleDto.setTotal(sale.getTotal());
        return saleDto;
    }

    private static Sale fromSaleDto(final SaleDto saleDto) {

        Sale sale = new Sale();
        sale.setSaleId(saleDto.getSaleId());
        sale.setCustomerName(saleDto.getCustomerName());
        sale.setAddress(saleDto.getAddress());
        sale.setMedicines(saleDto.getMedicines());
        sale.setTotal(saleDto.getTotal());
        return sale;
    }


    @Override
    public SaleDto addSale(SaleDto saleDto) {
        Sale sale = saleRepository.save(fromSaleDto(saleDto));
        return saleDto;
    }





    @Override
    public List<Sale> listAllSales() {
        return saleRepository.findAll();
    }



    @Override
    public SaleDto saveSale(SaleDto saleDto) {

        Long total = 0L;
        List<Medicine> medicines = saleDto.getMedicines();
        for (Medicine medicine : medicines) {
            Long count = medicine.getCount();

            Medicine soldMedicine = medicineService.getById(medicine.getMedicineId());
            if (count > soldMedicine.getQuantity()) {
                throw new OutOfStockException(count);
            }
            soldMedicine.setQuantity(soldMedicine.getQuantity() - count);
            medicineService.save(soldMedicine);
            total += count * soldMedicine.getSellingPrice();
        }

        saleDto.setTotal(total);

        Sale sale = fromSaleDto(saleDto);
        saleRepository.save(sale);
        return saleDto;

    }



    @Override
    public Sale getById(Long id) {
        Sale sale=saleRepository.findById(id).orElseThrow(()->new SaleNotFoundException(id));
        SaleDto saleDto=fromSale(sale);
        return sale;
    }


}