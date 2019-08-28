package com.finalassignment.pharmacyManagement.service.serviceImpl;


import com.finalassignment.pharmacyManagement.dto.PharmacistDto;
import com.finalassignment.pharmacyManagement.exceptionhandling.PharmacistNotFoundException;
import com.finalassignment.pharmacyManagement.model.Pharmacist;
import com.finalassignment.pharmacyManagement.repository.PharmacistRepository;
import com.finalassignment.pharmacyManagement.service.ExPharmacistService;
import com.finalassignment.pharmacyManagement.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PharmacistServiceImpl implements PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private ExPharmacistService exPharmacistService;


    public PharmacistServiceImpl(PharmacistRepository pharmacistRepository) {
        this.pharmacistRepository = pharmacistRepository;
    }

    //This is entity converter method which changes entity from Pharmacist to PharmacistDto

    private static PharmacistDto fromPharmacist(final Pharmacist pharmacist) {

        PharmacistDto pharmacistDto = new PharmacistDto();
        pharmacistDto.setPharmacistId(pharmacist.getPharmacistId());
        pharmacistDto.setPharmacistName(pharmacist.getPharmacistName());
        pharmacistDto.setAddress(pharmacist.getAddress());
        pharmacistDto.setAdharNo(pharmacist.getAdharNo());
        pharmacistDto.setContactNo(pharmacist.getContactNo());
        pharmacistDto.setEmail(pharmacist.getEmail());
        return pharmacistDto;
    }

    //This is entity converter method which changes entity from PharmacistDto to Pharmacist
    private static Pharmacist fromPharmacistDto(final PharmacistDto pharmacistDto) {

        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setPharmacistId(pharmacistDto.getPharmacistId());
        pharmacist.setPharmacistName(pharmacistDto.getPharmacistName());
        pharmacist.setAddress(pharmacistDto.getAddress());
        pharmacist.setAdharNo(pharmacistDto.getAdharNo());
        pharmacist.setContactNo(pharmacistDto.getContactNo());
        pharmacist.setEmail(pharmacistDto.getEmail());
        return pharmacist;
    }


    @Override
    public List<PharmacistDto> listAllPharmacist() {
        List<Pharmacist> pharmacists = pharmacistRepository.findAll();
        List<PharmacistDto> pharmacistDtos = null;
        if (!CollectionUtils.isEmpty(pharmacists)) {
            pharmacistDtos = new ArrayList<>();
            //loop through all pharmacists
            for (Pharmacist pharmacist : pharmacists) {
                PharmacistDto pharmacistDto = fromPharmacist(pharmacist);
                pharmacistDtos.add(pharmacistDto);
            }
        }
        return pharmacistDtos;
    }

    @Override
    public PharmacistDto save(PharmacistDto pharmacistDto) {

        Pharmacist pharmacist = pharmacistRepository.save(fromPharmacistDto(pharmacistDto));
        return pharmacistDto;

    }

    @Override
    public PharmacistDto getById(Long id) {
        Pharmacist pharmacist = pharmacistRepository.findById(id).orElseThrow(() -> new PharmacistNotFoundException(id));
        PharmacistDto pharmacistDto = fromPharmacist(pharmacist);
        return pharmacistDto;
    }
//    when Pharmacist get deleted, Pharmacist will move to ExPharmacist
    @Override
    public void delete(long id) {
        Pharmacist pharmacist = pharmacistRepository.findById(id).get();
        exPharmacistService.movetoExPharmacist(pharmacist);
        pharmacistRepository.deleteById(id);
    }


}

