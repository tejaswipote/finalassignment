package com.finalassignment.pharmacyManagement.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 *  *This is a model class that contains details of Expired stock
 */
@Getter
@Setter
@Entity
@Table(name = "expired_stock")
public class ExpiredStock {

    @Id
    @Column(name = "medicine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;
    @Column(name = "medicine_name")
    private String medicineName;
    @Column(name = "category")
    private String category;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "cost_price")
    private Long costPrice;

    @Column(name = "quantity")

    private Long quantity;
    @Column(name = "manufacturing_date")
    private Date manufacturingDate;
    @Column(name = "expiry_date")
    private Date expiryDate;


}
