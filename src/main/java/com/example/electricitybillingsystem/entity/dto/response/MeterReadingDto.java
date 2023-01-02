package com.example.electricitybillingsystem.entity.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MeterReadingDto {

    private Long id;
    private Long propertyId;
    private int meterReading;

}
