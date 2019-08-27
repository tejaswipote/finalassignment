package com.finalassignment.pharmacyManagement.exceptionhandling;

public class ExPharmacistNotFoundException extends RuntimeException {
    private Long exPharmacistId;


    public ExPharmacistNotFoundException(Long exPharmacistId) {

        this.exPharmacistId = exPharmacistId;

    }

}