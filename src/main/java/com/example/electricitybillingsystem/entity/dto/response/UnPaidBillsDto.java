package com.example.electricitybillingsystem.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnPaidBillsDto {


    private Long id;
    private Long propertyId;
    private double unpaidBill;

    public UnPaidBillsDto(Long propertyId, double unpaidBill) {
        this.propertyId = propertyId;
        this.unpaidBill = unpaidBill;
    }
}
