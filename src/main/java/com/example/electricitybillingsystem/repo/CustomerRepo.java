package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

    public List<Customer> findByAll();

    public Customer findById(Integer id);

    public Customer findByDrivingLicence(Integer drivingLicence);

    public Customer findByProperty(Integer id);

    public Customer findByBill(Integer id);

    public Customer findByAddress(Integer id);
}
