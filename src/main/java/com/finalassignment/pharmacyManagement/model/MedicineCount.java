package com.finalassignment.pharmacyManagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class MedicineCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long medicineId;
    private Long saleId;
    private Long count;


}
