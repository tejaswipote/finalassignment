package com.finalassignment.pharmacyManagement.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class PharmacistDto {


    private Long pharmacistId;
    private String pharmacistName;
    private Long contactNo;
    private Date workingSince;
    private String address;
    private Long adharNo;
    private String email;
}
