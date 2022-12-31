package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Address;
import com.example.electricitybillingsystem.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findCustomerById(Long id);


    Customer findCustomerByLicence(int licence);

//    List<Customer> findCustomerByProperty(int property);

     List<Customer> findCustomerByAddress_Id(Long id);
}
