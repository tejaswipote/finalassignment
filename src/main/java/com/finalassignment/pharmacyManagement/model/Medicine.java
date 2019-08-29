package com.finalassignment.pharmacyManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.Set;

/**
 * This is a model class that contains details of Medicine
 */
@Getter
@Setter
@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    @Column(name = "medicine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;
    @NonNull
    @Column(name = "medicine_name")
    private String medicineName;
    @Column(name = "category")
    private String category;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "cost_price")
    private Long costPrice;
    @Column(name = "selling_price")
    private Long sellingPrice;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "manufacturing_date")

    @PastOrPresent
    private Date manufacturingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

    @Column(name = "expiry_date")
    @FutureOrPresent
    private Date expiryDate;


    @ManyToMany(mappedBy = "medicines")
    @JsonBackReference
    private Set<Sale> sales;
    @Column(name = "count")

    private Long count;

}
