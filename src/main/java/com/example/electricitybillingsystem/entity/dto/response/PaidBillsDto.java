package com.example.electricitybillingsystem.entity.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class PaidBillsDto {

    private double billReading;
    private Date date;
}
