package com.finalassignment.pharmacyManagement.ExceptionHandling;

public class MedicineNotFoundException extends RuntimeException {
    private Long medicineId;


    public MedicineNotFoundException(Long medicineId) {

        this.medicineId = medicineId;

    }

}