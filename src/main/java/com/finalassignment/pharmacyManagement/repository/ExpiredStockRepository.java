package com.finalassignment.pharmacyManagement.repository;


import com.finalassignment.pharmacyManagement.model.ExpiredStock;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpiredStockRepository extends JpaRepository<ExpiredStock, Long> {

}