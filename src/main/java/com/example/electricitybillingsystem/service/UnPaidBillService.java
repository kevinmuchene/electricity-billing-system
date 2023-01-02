package com.example.electricitybillingsystem.service;

import com.example.electricitybillingsystem.entity.dto.request.UnPaidBillsReqDto;
import com.example.electricitybillingsystem.entity.dto.response.PaidBillsDto;
import com.example.electricitybillingsystem.entity.dto.response.UnPaidBillsDto;

import java.util.List;

public interface UnPaidBillService {

    List<UnPaidBillsReqDto> findAll();

    UnPaidBillsDto findUnPaidBillsByPropertyId(Long id);

    void save(UnPaidBillsDto unPaidBillsDto);

    UnPaidBillsDto update(Long paidBillsId, UnPaidBillsDto unPaidBillsDto);

    void delete(Long id);
}
