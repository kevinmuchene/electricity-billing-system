package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.Date;
import java.util.List;

@Repository
public interface BillRepo extends CrudRepository<Bill, Long> {

     List<Bill> findAll();

     Bill findBillById(Long id);

     List<Bill> findBillByDate(Date date);

     List<Bill> findBillByProperty_Id(Long id);

     void deleteById(Long bilId);
}
