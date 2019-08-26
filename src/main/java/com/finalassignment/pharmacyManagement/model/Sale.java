package com.finalassignment.pharmacyManagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sale")
public class Sale {
    Long total;
    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long saleId;
    private String customerName;
    private String address;
    @ManyToMany
    private List<Medicine> medicines = new ArrayList<>();

}
