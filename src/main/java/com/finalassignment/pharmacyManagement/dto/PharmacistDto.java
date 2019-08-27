package com.finalassignment.pharmacyManagement.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date workingSince;
    private String address;
    private Long adharNo;
    private String email;
    private String password;
}
