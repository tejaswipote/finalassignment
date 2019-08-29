package com.finalassignment.pharmacyManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  *This is a model class that contains details of Sale
 */
@Getter
@Setter
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long saleId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "address")
    private String address;
    @Column(name = "date")
    private Date date;
    @ManyToMany
    @JsonBackReference
    private List<Medicine> medicines = new ArrayList<>();
    @Column(name = "total")
    private Long total;
}
