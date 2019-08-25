package com.finalassignment.pharmacyManagement.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table
public class MedicineDetailsToUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;
    private String medicineName;
    private String category;
    private String manufacturer;
    private Long sellingPrice;
    private Date expiryDate;


}

