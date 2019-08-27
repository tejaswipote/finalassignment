package com.finalassignment.pharmacyManagement.exceptionhandling;



public class OutOfStockException extends RuntimeException {
    private Long count;


    public OutOfStockException(Long count) {

        this.count = count;

    }

}