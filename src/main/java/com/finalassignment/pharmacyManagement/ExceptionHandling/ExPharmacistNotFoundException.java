package com.finalassignment.pharmacyManagement.ExceptionHandling;

public class ExPharmacistNotFoundException extends RuntimeException {
    private Long exPharmacistId;


    public ExPharmacistNotFoundException(Long exPharmacistId) {

        this.exPharmacistId = exPharmacistId;

    }

}