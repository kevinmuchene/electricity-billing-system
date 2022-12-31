package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.MeterReading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReadingRepo extends CrudRepository<MeterReading, Long> {

     List<MeterReading> findAll();

     MeterReading findMeterReadingById(Long meterReadingId);

     List<MeterReading> findMeterReadingByPropertyId(Long id);

     void deleteById(long meterReadingId);
}
