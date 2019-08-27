package com.finalassignment.pharmacyManagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Pharmacist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pharmacistId;
    private String pharmacistName;
    private Long contactNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

    private Date workingSince;
    private String address;
    private Long adharNo;
    @Email
    private String email;

    private String password;


}
