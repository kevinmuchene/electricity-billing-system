package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Bill;
import org.springframework.data.repository.CrudRepository;

import java.time.Month;
import java.util.List;

public interface BillRepo extends CrudRepository<Bill, Long> {

    public List<Bill> findAll();

    public List<Bill> findByCustomerId(Long id);

    public List<Bill> findByMonth(Month month);
}
