package com.finalassignment.pharmacyManagement.ExceptionHandling;


public class SaleNotFoundException extends RuntimeException {
    private Long saleId;


    public SaleNotFoundException(Long saleId) {

        this.saleId = saleId;

    }


}



