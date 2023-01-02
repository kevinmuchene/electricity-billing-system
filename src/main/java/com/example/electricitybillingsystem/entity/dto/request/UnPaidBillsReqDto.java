package com.example.electricitybillingsystem.entity.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnPaidBillsReqDto {

    private Long id;
    private Long propertyId;
    private double unpaidBill;
}
