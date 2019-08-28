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
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class MedicineController {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private MedicineService medicineService;
    /**
     *
     * @return List of all Medicine
     */
    @GetMapping("/allMedicine")
    public ResponseEntity<List> findAllMedicine() {
        LOGGER.log(Level.INFO, "retrieving all medicines");

        return ResponseEntity.ok(medicineService.listAllMedicine());
    }


    /**
     *
     * @param medicineId
     * @return Medicine details for the given id
     */
    @GetMapping("/getMedicine/{medicineId}")
    public MedicineDto getMedicine(@PathVariable Long medicineId) {
        LOGGER.log(Level.INFO, "getting a medicine  details for medicineId "+ medicineId);


        return medicineService.getById(medicineId);
    }

    /**
     * Delete Medicine of given id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteMedicine/{id}")
    public ResponseEntity<Long> deleteMedicine(@PathVariable Long id) {
        LOGGER.log(Level.INFO, "deleting a medicine  details for medicineId "+ id);

        medicineService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //

    /**
     * Add given medicine
     * @param medicineDto
     * @return
     */
    @PostMapping("/addMedicine")
    public ResponseEntity<MedicineDto> addMedicine(@RequestBody MedicineDto medicineDto) {
        LOGGER.log(Level.INFO, "adding new medicine ");


        MedicineDto addMedicine = medicineService.save(medicineDto);
        return new ResponseEntity(addMedicine, new HttpHeaders(), HttpStatus.OK);

    }

    /**
     * Update medicine details such as quantity, Manufacturing date & Expiry date
     * @param id
     * @param medicineDto
     * @return
     */
    @PatchMapping("/updateMedicine/{id}")
    public ResponseEntity<MedicineDto> updateQuantity(@PathVariable Long id,
                                                      @Valid @RequestBody MedicineDto medicineDto) {
        LOGGER.log(Level.INFO, "updating medicine   details for id "+ id);

        MedicineDto medicinetoUpdate = medicineService.getById(id);
        medicinetoUpdate.setQuantity(medicineDto.getQuantity());
        medicinetoUpdate.setManufacturingDate(medicineDto.getManufacturingDate());
        medicinetoUpdate.setExpiryDate(medicineDto.getExpiryDate());
        medicineService.save(medicinetoUpdate);
        return ResponseEntity.ok(medicinetoUpdate);
    }

}

