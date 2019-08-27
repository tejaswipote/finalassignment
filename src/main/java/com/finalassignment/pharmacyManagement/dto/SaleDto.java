package com.finalassignment.pharmacyManagement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.finalassignment.pharmacyManagement.model.Medicine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaleDto {


    private Long saleId;
    private String customerName;
    private String address;
    @JsonBackReference
    private List<Medicine> medicines = new ArrayList<>();
    private Long total;
}
