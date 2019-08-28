package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.dto.MedicineDto;
import com.finalassignment.pharmacyManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    //Returns the List of all Medicine
    @GetMapping("/allMedicine")
    public ResponseEntity<List> findAllMedicine() {
        return ResponseEntity.ok(medicineService.listAllMedicine());
    }

    //Gives Medicine details for the given id
    @GetMapping("/getMedicine/{medicineId}")
    public MedicineDto getMedicine(@PathVariable Long medicineId) {

        return medicineService.getById(medicineId);
    }

    //Delete Medicine of given id
    @DeleteMapping(value = "/deleteMedicine/{id}")
    public ResponseEntity<Long> deleteMedicine(@PathVariable Long id) {
        medicineService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //Add given medicine
    @PostMapping("/addMedicine")
    public ResponseEntity<MedicineDto> addMedicine(@RequestBody MedicineDto medicineDto) {

        MedicineDto addMedicine = medicineService.save(medicineDto);
        return new ResponseEntity(addMedicine, new HttpHeaders(), HttpStatus.OK);

    }

    //Update medicine details such as quantity, Manufacturing date & Expiry date
    @PatchMapping("/updateMedicine/{id}")
    public ResponseEntity<MedicineDto> updateQuantity(@PathVariable Long id,
                                                      @Valid @RequestBody MedicineDto medicineDto) {
        MedicineDto medicinetoUpdate = medicineService.getById(id);
        medicinetoUpdate.setQuantity(medicineDto.getQuantity());
        medicinetoUpdate.setManufacturingDate(medicineDto.getManufacturingDate());
        medicinetoUpdate.setExpiryDate(medicineDto.getExpiryDate());
        medicineService.save(medicinetoUpdate);
        return ResponseEntity.ok(medicinetoUpdate);
    }

}

