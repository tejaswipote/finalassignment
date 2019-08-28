package com.finalassignment.pharmacyManagement.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="ex_pharmacist")
public class ExPharmacist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacist_id")
    private Long pharmacistId;
    @Column(name = "pharmacist_name")
    private String pharmacistName;
    @Column(name = "contact_no")
    private Long contactNo;
    @Column(name = "retired_on")
    private Date retiredOn;
    @Column(name = "address")
    private String address;
    @Column(name = "adhar_no")
    private Long adharNo;
    @Column(name = "email")
    private String email;

}
