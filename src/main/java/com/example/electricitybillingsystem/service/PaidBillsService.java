package com.example.electricitybillingsystem.service;

import com.example.electricitybillingsystem.entity.dto.response.MeterReadingDto;
import com.example.electricitybillingsystem.entity.dto.response.PaidBillsDto;

import java.util.List;

public interface PaidBillsService {

    List<PaidBillsDto> findAll();

    PaidBillsDto findPaidBillsByPropertyId(Long id);

    void save(PaidBillsDto paidBillsDto);

    PaidBillsDto update(Long paidBillsId, PaidBillsDto paidBillsDto);

    void delete(Long id);
}
