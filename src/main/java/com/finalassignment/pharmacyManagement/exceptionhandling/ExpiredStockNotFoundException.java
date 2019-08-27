package com.finalassignment.pharmacyManagement.exceptionhandling;


public class ExpiredStockNotFoundException extends RuntimeException {

    private Long exStockId;

    public ExpiredStockNotFoundException(Long exStockId) {


        this.exStockId = exStockId;

    }

}