package com.example.electricitybillingsystem.controller;

import com.example.electricitybillingsystem.entity.dto.request.UnPaidBillsReqDto;
import com.example.electricitybillingsystem.entity.dto.response.UnPaidBillsDto;
import com.example.electricitybillingsystem.service.implementation.UnPaidBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("api/v1/unpaidbills")
public class UnPaidBillsController {

    @Autowired
    private UnPaidBillServiceImpl unPaidBillService;

    @GetMapping()
    public List<UnPaidBillsReqDto> getUnpaidBills(){
        return unPaidBillService.findAll();
    }

    @PostMapping()
    public void save(@RequestBody UnPaidBillsDto unPaidBillsDto){
        unPaidBillService.save(unPaidBillsDto);
    }

}
