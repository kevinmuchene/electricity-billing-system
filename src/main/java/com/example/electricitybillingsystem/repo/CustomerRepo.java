package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findCustomerById(Long customerId);

    Customer findCustomerByFirstName(String name);

    Customer findCustomerByLastName(String name);


    Customer findCustomerByLicence(int customerLicence);

//    List<Customer> findCustomerByProperty(int property);

     List<Customer> findCustomerByAddress_Id(Long addressId);

     void deleteCustomerById(long customerId);
}
