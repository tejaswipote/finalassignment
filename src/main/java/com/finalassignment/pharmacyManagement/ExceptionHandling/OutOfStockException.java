package com.finalassignment.pharmacyManagement.ExceptionHandling;



public class OutOfStockException extends RuntimeException {
    private Long count;


    public OutOfStockException(Long count) {

        this.count = count;

    }

}