package com.finalassignment.pharmacyManagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ExPharmacistDto {
    private Long pharmacistId;
    private String pharmacistName;
    private Long contactNo;
    private Date retiredOn;
    private String address;
    private Long adharNo;
    private String email;
}
