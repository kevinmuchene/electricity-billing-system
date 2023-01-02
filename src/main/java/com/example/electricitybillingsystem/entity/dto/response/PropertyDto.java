package com.example.electricitybillingsystem.entity.dto.response;

import com.example.electricitybillingsystem.entity.Address;
import com.example.electricitybillingsystem.entity.MeterReading;
import com.example.electricitybillingsystem.entity.UnPaidBills;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PropertyDto {

    private Long id;
    private Long customerId;
    private String type;
    private List<MeterReading> meterReadings;
    private List<UnPaidBills> unPaidBills;
//    private Address address;

}
