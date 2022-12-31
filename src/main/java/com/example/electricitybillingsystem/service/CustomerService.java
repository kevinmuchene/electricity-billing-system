package com.example.electricitybillingsystem.service;


import com.example.electricitybillingsystem.entity.dto.response.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long id);

    CustomerDto getCustomerByFirstName(String customerName);

    CustomerDto getCustomerByLastName(String customerName);

    CustomerDto getCustomerByLicence(int licenceId);

    CustomerDto getCustomerByProperty(int propertyId);

    List<CustomerDto> getCustomerByAddress_Id(Long id);
}
