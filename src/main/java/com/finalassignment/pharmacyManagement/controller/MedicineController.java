package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.MedicineDto;
import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.service.MedicineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class MedicineController {


    @Autowired
    private MedicineService medicineService;

    /**
     * @return List of all Medicine
     */
    @GetMapping("/allMedicine")
    public ResponseEntity<List> findAllMedicine() {
        log.info("retrieving all medicines");

        return ResponseEntity.ok(medicineService.listAllMedicine());
    }


    /**
     * @param medicineId
     * @return Medicine details for the given id
     */
    @GetMapping("/getMedicine/{medicineId}")
    public MedicineDto getMedicine(@PathVariable Long medicineId) {
        log.info("getting a medicine  details for medicineId " + medicineId);


        return medicineService.getById(medicineId);
    }

    /**
     * Delete Medicine of given id
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteMedicine/{id}")
    public ResponseEntity<Long> deleteMedicine(@PathVariable Long id) {
        log.info("deleting a medicine  details for medicineId " + id);

        medicineService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //

    /**
     * Add given medicine
     *
     * @param medicineDto
     * @return
     */
    @PostMapping("/addMedicine")
    public ResponseEntity<Medicine> addMedicine(@RequestBody MedicineDto medicineDto) {
        log.info("adding new medicine ");


        Medicine addMedicine = medicineService.save(medicineDto);
        return new ResponseEntity(addMedicine, new HttpHeaders(), HttpStatus.OK);

    }

    /**
     * Update medicine details such as quantity, Manufacturing date & Expiry date
     *
     * @param id
     * @param medicine
     * @return
     */
    @PatchMapping("/updateMedicine/{id}")
    public ResponseEntity<MedicineDto> updateQuantity(@PathVariable Long id,
                                                      @Valid @RequestBody Medicine medicine) {
        log.info("updating medicine   details for id " + id);

        MedicineDto medicinetoUpdate = medicineService.getById(id);
        medicinetoUpdate.setMedicineId(id);
        medicinetoUpdate.setQuantity(medicine.getQuantity());
        medicinetoUpdate.setManufacturingDate(medicine.getManufacturingDate());
        medicinetoUpdate.setExpiryDate(medicine.getExpiryDate());
         medicineService.save(medicinetoUpdate);

        return ResponseEntity.ok(medicinetoUpdate);
    }


}

