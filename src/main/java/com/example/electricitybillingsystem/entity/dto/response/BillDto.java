package com.example.electricitybillingsystem.entity.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BillDto {

    private Long id;
    private int reading;
//    private Date date;
}
