package com.finalassignment.pharmacyManagement.service.serviceImpl;

import com.finalassignment.pharmacyManagement.dto.MedicineDto;
import com.finalassignment.pharmacyManagement.dto.SaleDto;
import com.finalassignment.pharmacyManagement.exceptionhandling.OutOfStockException;
import com.finalassignment.pharmacyManagement.exceptionhandling.SaleNotFoundException;
import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.model.Sale;
import com.finalassignment.pharmacyManagement.repository.SaleRepository;
import com.finalassignment.pharmacyManagement.service.MedicineService;
import com.finalassignment.pharmacyManagement.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

@Slf4j
@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    /**
     * This is entity converter method which changes entity from Sale to SaleDto
     *
     * @param sale
     * @return
     */
    private static SaleDto fromSale(final Sale sale) {

        SaleDto saleDto = new SaleDto();
        saleDto.setCustomerName(sale.getCustomerName());
        saleDto.setAddress(sale.getAddress());
        saleDto.setMedicines(sale.getMedicines());
        saleDto.setTotal(sale.getTotal());
        saleDto.setDate(new Date());
        return saleDto;
    }


    /**
     * This is entity converter method which changes entity from SaleDto  to Sale
     *
     * @param saleDto
     * @return
     */
    private Sale fromSaleDto(final SaleDto saleDto) {
        Sale sale = new Sale();
        sale.setCustomerName(saleDto.getCustomerName());
        sale.setAddress(saleDto.getAddress());
        sale.setMedicines(saleDto.getMedicines());
        sale.setTotal(saleDto.getTotal());
        sale.setDate(new Date());
        return sale;
    }

    /**
     * @param saleDto
     * @return
     */
    @Override
    public SaleDto addSale(SaleDto saleDto) {
        Sale sale = saleRepository.save(fromSaleDto(saleDto));
        return saleDto;
    }


    @Override
    public List<SaleDto> listAllSales() {
        List<Sale> sales = saleRepository.findAll();
        List<SaleDto> saleDtos = null;


        if (!CollectionUtils.isEmpty(sales)) {
            saleDtos = new ArrayList<>();
            //loop through all sales
            for (Sale sale : sales) {
                SaleDto saleDto = fromSale(sale);
                saleDtos.add(saleDto);
            }
        }
        return saleDtos;
    }

    /**
     * add sale and calculate total price
     *
     * @param saleDto
     * @return
     */

    @Override
    public SaleDto saveSale(SaleDto saleDto) {
        Long total = 0L;
        List<Medicine> medicines = saleDto.getMedicines();
        log.info("calculating total ");

        //loops through all Medicine in sale
        for (Medicine medicine : medicines) {
            Long count = medicine.getCount();

            MedicineDto soldMedicine = medicineService.getById(medicine.getMedicineId());
            //check if stock is available or not
            if (count > soldMedicine.getQuantity()) {
                throw new OutOfStockException(count);
            }
            //decrease the quantity of medicine
            soldMedicine.setQuantity(soldMedicine.getQuantity() - count);
            medicineService.save(soldMedicine);
            //calculate total price for sale
            total += count * soldMedicine.getSellingPrice();
        }
        saleDto.setDate(new Date());
        saleDto.setTotal(total);

        Sale sale = fromSaleDto(saleDto);
        saleRepository.save(sale);
        return saleDto;

    }

    /**
     * @param id
     * @return sale for given id
     */

    @Override
    public SaleDto getById(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new SaleNotFoundException(id));
        SaleDto saleDto = fromSale(sale);
        return saleDto;
    }


}