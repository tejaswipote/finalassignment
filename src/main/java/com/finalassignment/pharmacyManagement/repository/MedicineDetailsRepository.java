package com.finalassignment.pharmacyManagement.repository;


import com.finalassignment.pharmacyManagement.model.MedicineDetailsToUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicineDetailsRepository extends JpaRepository<MedicineDetailsToUser, Long> {

}