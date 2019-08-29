package com.finalassignment.pharmacyManagement.service.serviceImpl;


import com.finalassignment.pharmacyManagement.model.MedicineCount;
import com.finalassignment.pharmacyManagement.repository.MedicineCountRepository;
import com.finalassignment.pharmacyManagement.service.MedicineCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicineCountServiceImpl implements MedicineCountService {

    @Autowired
    private MedicineCountRepository medicineCountRepository;

    /**
     * save Medicine into database
     *
     * @param medicineCount
     * @return
     */
    @Override
    public MedicineCount save(MedicineCount medicineCount) {
        return medicineCountRepository.save(medicineCount);

    }
}
