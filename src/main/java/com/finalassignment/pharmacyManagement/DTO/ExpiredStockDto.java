package com.finalassignment.pharmacyManagement.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ExpiredStockDto {

    private Long medicineId;
    private String medicineName;
    private String category;
    private Long costPrice;
    private Long quantity;

    private Date manufacturingDate;

    private Date expiryDate;
}
