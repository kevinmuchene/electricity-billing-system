package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.MeterReading;
import com.example.electricitybillingsystem.entity.PaidBills;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaidBillRepo extends CrudRepository<PaidBills, Long> {

    List<PaidBills> findAll();

    PaidBills findPaidBillsById(Long id);

    List<PaidBills> findPaidBillsByPropertyId(Long id);

    void deleteById(Long Id);
}
