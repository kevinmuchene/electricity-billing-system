package com.example.electricitybillingsystem.service.implementation;

import com.example.electricitybillingsystem.entity.Customer;
import com.example.electricitybillingsystem.entity.Property;
import com.example.electricitybillingsystem.entity.dto.response.CustomerDto;
import com.example.electricitybillingsystem.repo.CustomerRepo;
import com.example.electricitybillingsystem.repo.PropertyRepo;
import com.example.electricitybillingsystem.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    ModelMapper modelMapper;

//    public CustomerServiceImpl(CustomerRepo customerRepo) {
//        this.customerRepo = customerRepo;
//    }

    @Override
    public List<CustomerDto> getAllCustomers() {

        var customers = customerRepo.findAll();

        return customers
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {

           return modelMapper
                   .map(customerRepo.findCustomerById(id), CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerByFirstName(String customerName) {

        return modelMapper
                .map(customerRepo.findCustomerByFirstName(customerName), CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerByLastName(String customerName) {

        return modelMapper
                .map(customerRepo.findCustomerByLastName(customerName), CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerByLicence(int licenceId) {

        Customer customer = customerRepo.findCustomerByLicence(licenceId);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerByProperty(Long propertyId) {
        Property property = propertyRepo.findPropertyById(propertyId);

        Customer customer = property.getCustomer();
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getCustomerByAddress_Id(Long id) {

        var customers = customerRepo.findCustomerByAddress_Id(id);

        return customers
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(CustomerDto customerDto) {
        customerRepo.save(modelMapper.map(customerDto, Customer.class));
    }

    @Override
    public CustomerDto update(Long customerId, CustomerDto customerDto) {

        Customer customer = customerRepo.findCustomerById(customerId);

        if(customerDto.getFirstName() != null) {
            customer.setFirstName(customerDto.getFirstName());
        }
        if(customerDto.getLastName() != null) {
            customer.setLastName(customerDto.getLastName());
        }
        if(customerDto.getLicence() != null) {
            customer.setLicence(customerDto.getLicence());
        }

        if(customerDto.getAddress() != null) {
            customer.setAddress(customerDto.getAddress());
        }

        customerRepo.save(customer);

        return modelMapper.map(customer, CustomerDto.class);

    }

    @Override
    public void delete(Long customerId) {
        customerRepo.deleteCustomerById(customerId);
    }
}
