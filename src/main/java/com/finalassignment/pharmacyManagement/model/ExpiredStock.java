package com.finalassignment.pharmacyManagement.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "manufacturing_date")

    //@PastOrPresent
    private Date manufacturingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "expiry_date")

    //@FutureOrPresent
    private Date expiryDate;


}
