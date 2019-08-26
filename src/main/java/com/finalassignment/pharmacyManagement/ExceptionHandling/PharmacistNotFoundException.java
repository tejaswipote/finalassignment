package com.finalassignment.pharmacyManagement.ExceptionHandling;


public class PharmacistNotFoundException extends RuntimeException {
    private Long pharmacistId;


    public PharmacistNotFoundException(Long pharmacistId) {

        this.pharmacistId = pharmacistId;

    }


}
