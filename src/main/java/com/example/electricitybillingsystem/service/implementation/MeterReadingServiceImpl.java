package com.example.electricitybillingsystem.service.implementation;

import com.example.electricitybillingsystem.entity.MeterReading;
import com.example.electricitybillingsystem.entity.dto.response.MeterReadingDto;
import com.example.electricitybillingsystem.repo.MeterReadingRepo;
import com.example.electricitybillingsystem.service.MeterReadingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeterReadingServiceImpl implements MeterReadingService {

    @Autowired
    private MeterReadingRepo meterReadingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MeterReadingDto> findAll() {

        var meterReadings = meterReadingRepo.findAll();

        return meterReadings
                .stream()
                .map(meterReading -> modelMapper.map(meterReading, MeterReadingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MeterReadingDto> findMeterReadingByPropertyId(Long id) {

        var meterReadings = meterReadingRepo.findMeterReadingByPropertyId(id);

        return meterReadings
                .stream()
                .map(meterReading -> modelMapper.map(meterReading, MeterReadingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(MeterReadingDto meterReadingDto) {
        meterReadingRepo.save(modelMapper.map(meterReadingDto, MeterReading.class));
    }

    @Override
    public MeterReadingDto update(Long meterReadingId, MeterReadingDto meterReadingDto) {

        MeterReading meterReading = meterReadingRepo.findMeterReadingById(meterReadingId);

        if(meterReadingDto.getMeterReading() < 0) {
            meterReading.setMeterReading(meterReadingDto.getMeterReading());
        }

        if(meterReadingDto.getDate() != null) {
            meterReading.setDate(meterReadingDto.getDate());
        }

        meterReadingRepo.save(meterReading);

        return modelMapper.map(meterReading, MeterReadingDto.class);


    }

    @Override
    public void delete(Long meterReadingId) {
        meterReadingRepo.deleteMeterReadingById(meterReadingId);
    }
}
