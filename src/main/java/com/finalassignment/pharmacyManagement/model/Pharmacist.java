package com.finalassignment.pharmacyManagement.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 *  This is a model class that contains details of Pharmacist
 */
@Getter
@Setter
@Entity
@Table(name = "pharmacist")
public class Pharmacist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacist_id")
    private Long pharmacistId;
    @NonNull
    @Column(name = "pharmacist_name")
    private String pharmacistName;
    @Column(name = "contact_no")
    private Long contactNo;
    @Column(name = "working_since")
    private Date workingSince;
    @Column(name = "address")
    private String address;
    @Column(name = "adhar_no")
    private Long adharNo;
    @Column(name = "email")
    private String email;

}
