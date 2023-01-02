package com.example.electricitybillingsystem.controller;

import com.example.electricitybillingsystem.entity.Property;
import com.example.electricitybillingsystem.entity.dto.response.MeterReadingDto;
import com.example.electricitybillingsystem.entity.dto.response.PropertyDto;
import com.example.electricitybillingsystem.entity.dto.response.UnPaidBillsDto;
import com.example.electricitybillingsystem.service.implementation.MeterReadingServiceImpl;
import com.example.electricitybillingsystem.service.implementation.PropertyServiceImpl;
import com.example.electricitybillingsystem.service.implementation.UnPaidBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/meterreading")
public class MeterReadingController {

    @Autowired
    private MeterReadingServiceImpl meterReadingService;

    @Autowired
    private UnPaidBillServiceImpl unPaidBillService;

    @Autowired
    private PropertyServiceImpl propertyService;

    @GetMapping()
    public List<MeterReadingDto> getMeterReadings() {
        return meterReadingService.findAll();
    }

    @PostMapping
    public void saveMeterReading(@RequestBody MeterReadingDto meterReadingDto){
        meterReadingService.save(meterReadingDto);

        PropertyDto propertyDto = propertyService.getPropertyById(meterReadingDto.getPropertyId());

        double newBill = 0;

        if(propertyDto.getMeterReadings().size() > 1) {

            int previousReading = propertyDto
                    .getMeterReadings()
                    .get(propertyDto.getMeterReadings().size() - 2)
                    .getMeterReading();

            newBill = (meterReadingDto.getMeterReading() - previousReading) * 5.2;


        }




        UnPaidBillsDto unPaidBillsDto = new UnPaidBillsDto(meterReadingDto.getPropertyId(), newBill);

        unPaidBillService.save(unPaidBillsDto);

//        System.out.println(unPaidBillsDto);

//        propertyDto.getUnPaidBills().add(unPaidBillsDto)
        /*
        *
        * meterReadingDto.meterReading = 100
        * */
    }


}
