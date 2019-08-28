package com.finalassignment.pharmacyManagement.service.serviceImpl;

import com.finalassignment.pharmacyManagement.dto.ExPharmacistDto;
import com.finalassignment.pharmacyManagement.exceptionhandling.ExPharmacistNotFoundException;
import com.finalassignment.pharmacyManagement.model.ExPharmacist;
import com.finalassignment.pharmacyManagement.model.Pharmacist;
import com.finalassignment.pharmacyManagement.repository.ExPharmacistRepository;
import com.finalassignment.pharmacyManagement.service.ExPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class ExPharmacistServiceImpl implements ExPharmacistService {

    @Autowired
    private ExPharmacistRepository exPharmacistRepository;


    public ExPharmacistServiceImpl(ExPharmacistRepository exPharmacistRepository) {
        this.exPharmacistRepository = exPharmacistRepository;
    }


    /**
     * This method is entity converter from ExPharmacist to ExPharmacistDto
     *
     * @param exPharmacist
     * @return
     */
    private static ExPharmacistDto fromExPharmacist(final ExPharmacist exPharmacist) {

        ExPharmacistDto exPharmacistDto = new ExPharmacistDto();
        exPharmacistDto.setPharmacistName(exPharmacist.getPharmacistName());
        exPharmacistDto.setAddress(exPharmacist.getAddress());
        exPharmacistDto.setAdharNo(exPharmacist.getAdharNo());
        exPharmacistDto.setContactNo(exPharmacist.getContactNo());
        exPharmacistDto.setEmail(exPharmacist.getEmail());
        exPharmacistDto.setRetiredOn(new Date());
        return exPharmacistDto;
    }


    /**
     * This method is entity converter from  ExPharmacistDto to  ExPharmacist
     *
     * @param exPharmacistDto
     * @return
     */
    private static ExPharmacist fromExPharmacistDto(final ExPharmacistDto exPharmacistDto) {

        ExPharmacist exPharmacist = new ExPharmacist();
        exPharmacist.setPharmacistName(exPharmacistDto.getPharmacistName());
        exPharmacist.setAddress(exPharmacistDto.getAddress());
        exPharmacist.setAdharNo(exPharmacistDto.getAdharNo());
        exPharmacist.setContactNo(exPharmacistDto.getContactNo());
        exPharmacist.setEmail(exPharmacistDto.getEmail());
        exPharmacist.setRetiredOn(new Date());
        return exPharmacist;
    }

    /**
     * lists all ExPharmacist
     *
     * @return
     */
    @Override
    public List<ExPharmacistDto> listAllExPharmacist() {
        List<ExPharmacist> exPharmacists = exPharmacistRepository.findAll();
        List<ExPharmacistDto> exPharmacistDtos = null;
        if (!CollectionUtils.isEmpty(exPharmacists)) {
            exPharmacistDtos = new ArrayList<>();
            //loop through all ExPharmacist
            for (ExPharmacist exPharmacist : exPharmacists) {
                ExPharmacistDto exPharmacistDto = fromExPharmacist(exPharmacist);
                exPharmacistDtos.add(exPharmacistDto);
            }
        }
        return exPharmacistDtos;
    }

    /**
     * This method connverts pharmacist to ExPharmacist
     *
     * @param pharmacist
     */
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

    /**
     * @param id
     * @return a EXPharmacist of given Id
     */

    @Override
    public ExPharmacistDto getById(Long id) {
        ExPharmacist exPharmacist = exPharmacistRepository.findById(id).orElseThrow(() -> new ExPharmacistNotFoundException(id));
        ExPharmacistDto exPharmacistDto = fromExPharmacist(exPharmacist);
        return exPharmacistDto;
    }

    /**
     * delete EXPharmacist of given Id
     *
     * @param id
     */
    @Override
    public void deleteExPharmacist(long id) {
        exPharmacistRepository.deleteById(id);
    }

}
