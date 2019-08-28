package com.finalassignment.pharmacyManagement.controller;


import com.finalassignment.pharmacyManagement.service.ExpiredStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ExpiredStockController {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private ExpiredStockService expiredStockService;

    public ExpiredStockController(ExpiredStockService expiredStockService) {
        this.expiredStockService = expiredStockService;
    }

    /**
     *
     * @return all expired Stock in medical
     */
    @GetMapping("/allExpired")
    public ResponseEntity<List> findAllExStock() {
        LOGGER.log(Level.INFO, "getting all ExpirdStock ");

        return ResponseEntity.ok(expiredStockService.listAllStock());
    }

    //Delete the Expired Stock for given id

    /**
     * Delete the Expired Stock for given id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteExStock/{id}")
    public ResponseEntity<Long> deleteExStock(@PathVariable Long id) {
        LOGGER.log(Level.INFO, "deleting ExpirdStock for id  "+id);

        expiredStockService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
