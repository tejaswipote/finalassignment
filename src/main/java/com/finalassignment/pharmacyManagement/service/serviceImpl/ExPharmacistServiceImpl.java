package com.finalassignment.pharmacyManagement.service.serviceImpl;

import com.finalassignment.pharmacyManagement.ExceptionHandling.ExPharmacistNotFoundException;
import com.finalassignment.pharmacyManagement.model.ExPharmacist;
import com.finalassignment.pharmacyManagement.model.Pharmacist;
import com.finalassignment.pharmacyManagement.repository.ExPharmacistRepository;
import com.finalassignment.pharmacyManagement.service.ExPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class ExPharmacistServiceImpl implements ExPharmacistService {

    @Autowired
    private ExPharmacistRepository exPharmacistRepository;

    public List<ExPharmacist> listAllExPharmacist() {
        return exPharmacistRepository.findAll();
    }
    @Override
    public ExPharmacist getById(Long id) {
        return exPharmacistRepository.findById(id).orElseThrow(() -> new ExPharmacistNotFoundException(id));
    }

    @Override
    public void movetoExPharmacist(Pharmacist pharmacist) {
        ExPharmacist exPharmacist = new ExPharmacist();
        exPharmacist.setPharmacistName(pharmacist.getPharmacistName());
        exPharmacist.setContactNo(pharmacist.getContactNo());
        exPharmacist.setRetiredOn(new Date());
        exPharmacist.setAddress(pharmacist.getAddress());
        exPharmacist.setAdharNo(pharmacist.getAdharNo());
        exPharmacist.setEmail(pharmacist.getEmail());
        exPharmacistRepository.save(exPharmacist);
    }

    @Override
    public void deleteExPharmacist(long id) {
        exPharmacistRepository.deleteById(id);
    }

}
