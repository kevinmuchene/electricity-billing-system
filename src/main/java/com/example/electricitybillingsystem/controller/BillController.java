package com.example.electricitybillingsystem.controller;


import com.example.electricitybillingsystem.entity.dto.response.BillDto;
import com.example.electricitybillingsystem.service.implementation.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bills")
public class BillController {

    @Autowired
    private BillServiceImpl billService;

    @GetMapping()
    public List<BillDto> getBills() {
        return billService.getAllBills();
    }

    @GetMapping("/{id}")
    public BillDto getBillById(@PathVariable("id") Long id) {
        return billService.findBillById(id);
    }

    @PostMapping()
    public void saveBill(@RequestBody BillDto billDto) {
        billService.save(billDto);
    }

    @PutMapping("/{id}")
    public void updateBill(@PathVariable("id") Long billId, @RequestBody BillDto billDto){
        billService.update(billId, billDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable("id") Long id) {
        billService.delete(id);
    }
}
