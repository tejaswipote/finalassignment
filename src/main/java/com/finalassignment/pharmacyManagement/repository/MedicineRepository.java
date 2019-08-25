package com.finalassignment.pharmacyManagement.repository;

import com.finalassignment.pharmacyManagement.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}