package com.finalassignment.pharmacyManagement.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.finalassignment.pharmacyManagement.model.Sale;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MedicineDto {

    private Long medicineId;
    private String medicineName;
    private String category;
    private String manufacturer;
    private Long costPrice;
    private Long sellingPrice;
    private Long quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

    private Date manufacturingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

    private Date expiryDate;

    private Set<Sale> sales;

    private Long count;

}
