package com.finalassignment.pharmacyManagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
/**
 * This is DTO class for ExpiredStock entity
 */
@Getter
@Setter
@NoArgsConstructor
public class ExpiredStockDto {

    private Long medicineId;
    private String medicineName;
    private String category;
    private Long costPrice;
    private Long quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date manufacturingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date expiryDate;
}
