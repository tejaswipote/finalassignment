package com.finalassignment.pharmacyManagement.DTO;

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

    Long total;
    private Long saleId;
    private String customerName;
    private String address;
    private List<Medicine> medicines = new ArrayList<>();
}
