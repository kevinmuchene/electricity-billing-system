package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.MeterReading;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeterReadingRepo extends CrudRepository<MeterReading, Long> {

    public List<MeterReading> findByAll();

    public MeterReading findById(Integer id);
}
