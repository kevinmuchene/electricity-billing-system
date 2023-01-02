package com.example.electricitybillingsystem.repo;


import com.example.electricitybillingsystem.entity.PaidBills;
import com.example.electricitybillingsystem.entity.UnPaidBills;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnPaidBillRepo extends CrudRepository<UnPaidBills, Long> {

    List<UnPaidBills> findAll();

    UnPaidBills findUnPaidBillsById(Long id);

    List<UnPaidBills> findUnPaidBillsByPropertyId(Long id);

    void deleteById(Long Id);

}
