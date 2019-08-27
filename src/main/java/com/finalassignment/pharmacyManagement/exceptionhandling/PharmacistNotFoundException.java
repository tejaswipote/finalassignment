package com.finalassignment.pharmacyManagement.exceptionhandling;


public class PharmacistNotFoundException extends RuntimeException {
    private Long pharmacistId;


    public PharmacistNotFoundException(Long pharmacistId) {

        this.pharmacistId = pharmacistId;

    }


}
