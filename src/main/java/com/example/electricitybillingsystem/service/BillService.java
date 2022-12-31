package com.example.electricitybillingsystem.service;

import com.example.electricitybillingsystem.entity.dto.response.BillDto;

import java.util.Date;
import java.util.List;

public interface BillService {

    List<BillDto> getAllBills();

    BillDto findBillById(Long id);

    List<BillDto> findBillByDate(Date date);

    List<BillDto> findBillByProperty_Id(Long id);

    void save(BillDto billDto);

    BillDto update(Long billId, BillDto billDto);

    void delete(Long billId);
}
