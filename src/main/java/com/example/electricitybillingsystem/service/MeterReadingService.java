package com.example.electricitybillingsystem.service;

import com.example.electricitybillingsystem.entity.dto.response.MeterReadingDto;

import java.util.List;

public interface MeterReadingService {

    List<MeterReadingDto> findAll();

    List<MeterReadingDto> findMeterReadingByPropertyId(Long id);

    void save(MeterReadingDto meterReadingDto);

    MeterReadingDto update(Long meterReadingId, MeterReadingDto meterReadingDto);

    void delete(Long meterReadingId);
}
