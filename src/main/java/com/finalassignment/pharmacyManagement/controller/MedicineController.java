package com.finalassignment.pharmacyManagement.controller;

import com.finalassignment.pharmacyManagement.model.Medicine;
import com.finalassignment.pharmacyManagement.model.MedicineDetailsToUser;
import com.finalassignment.pharmacyManagement.service.MedicineDetailsService;
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

    @Autowired
    private MedicineDetailsService medicineDetailsService;

    @GetMapping("/allMedicine")
    public List<Medicine> findAllMedicine() {
        return medicineService.listAllMedicine();
    }


    @GetMapping("/getMedicine/{medicineId}")
    public Medicine getMedicine(@PathVariable Long medicineId) {
        return medicineService.getById(medicineId);
    }
//    @GetMapping("/getMedicine/{category}")
//    public Medicine getMedicine(@PathVariable Long category) {
//        return medicineService.getByCategory(category);
//    }

    @DeleteMapping(value = "/deleteMedicine/{id}")
    public ResponseEntity<Long> deleteMedicine(@PathVariable Long id) {


        medicineService.delete(id);


        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @PostMapping("/addMedicine")
    public String addMedicine(@RequestBody Medicine medicine) {
        MedicineDetailsToUser medicineDetailsToUser = new MedicineDetailsToUser();
        medicineDetailsToUser.setMedicineId(medicine.getMedicineId());
        medicineDetailsToUser.setMedicineName(medicine.getMedicineName());
        medicineDetailsToUser.setManufacturer(medicine.getManufacturer());
        medicineDetailsToUser.setCategory(medicine.getCategory());
        medicineDetailsToUser.setSellingPrice(medicine.getSellingPrice());
        medicineDetailsToUser.setExpiryDate(medicine.getExpiryDate());

        medicineDetailsService.save(medicineDetailsToUser);

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
//
//
//UPDATE single RECORDS
//
//

//    @PatchMapping("/patch/id")
//    public @ResponseBody ResponseEntity<Product> patchBrand(@PathVariable Long id) {
//        return new ResponseEntity<String>("PATCH Response", HttpStatus.OK);
//    }

