package com.finalassignment.pharmacyManagement.repository;


import com.finalassignment.pharmacyManagement.model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;



public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {

}