package com.finalassignment.pharmacyManagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Sale {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long saleId;
    private String customerName;
    private String address;


}
