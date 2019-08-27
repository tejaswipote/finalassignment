package com.finalassignment.pharmacyManagement.exceptionhandling;


public class SaleNotFoundException extends RuntimeException {
    private Long saleId;


    public SaleNotFoundException(Long saleId) {

        this.saleId = saleId;

    }


}



