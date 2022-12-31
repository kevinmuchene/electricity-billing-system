package com.example.electricitybillingsystem.entity.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MeterReading {

    private Long id;
    private int meterReading;
    private Date date;
}
