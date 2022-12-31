package com.example.electricitybillingsystem.controller;

import com.example.electricitybillingsystem.entity.Customer;
import com.example.electricitybillingsystem.entity.dto.response.CustomerDto;
import com.example.electricitybillingsystem.service.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin()

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping()
    public List<CustomerDto> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customerlicenceid/{id}")
    public CustomerDto getCustomerByLicenceId(@PathVariable("id") int id){

        return customerService.getCustomerByLicence(id);

    }

    @PostMapping()
    public void saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.save(customerDto);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable("id") Long customerId, @RequestBody CustomerDto customerDto) {
        customerService.update(customerId, customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.delete(id);
    }
}
