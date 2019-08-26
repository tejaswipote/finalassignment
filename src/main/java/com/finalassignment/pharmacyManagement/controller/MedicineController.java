package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;


    @GetMapping("/allMedicine")
    public List<Medicine> findAllMedicine() {
        return medicineService.listAllMedicine();
    }


    @GetMapping("/getMedicine/{medicineId}")
    public Medicine getMedicine(@PathVariable Long medicineId) {
        return medicineService.getById(medicineId);
    }

    @DeleteMapping(value = "/deleteMedicine/{id}")
    public ResponseEntity<Long> deleteMedicine(@PathVariable Long id) {


        medicineService.delete(id);


        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @PostMapping("/addMedicine")
    public String addMedicine(@RequestBody Medicine medicine) {

        medicineService.save(medicine);
        return "Medicine Successfully added";
    }


    @PutMapping("/medicine/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id,
                                                   @Valid @RequestBody Medicine medicine) {
        Medicine medicinetoUpdate = medicineService.getById(id);

        medicinetoUpdate.setMedicineId(medicine.getMedicineId());
        medicinetoUpdate.setMedicineName(medicine.getMedicineName());
        medicinetoUpdate.setCategory(medicine.getCategory());
        medicinetoUpdate.setCostPrice(medicine.getCostPrice());
        medicinetoUpdate.setSellingPrice(medicine.getSellingPrice());
        medicinetoUpdate.setQuantity(medicine.getQuantity());
        medicinetoUpdate.setManufacturingDate(medicine.getManufacturingDate());
        medicinetoUpdate.setExpiryDate(medicine.getExpiryDate());


        medicineService.save(medicinetoUpdate);
        return ResponseEntity.ok(medicinetoUpdate);
    }


}

