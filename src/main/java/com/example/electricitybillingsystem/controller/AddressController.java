package com.example.electricitybillingsystem.controller;

import com.example.electricitybillingsystem.entity.dto.response.AddressDto;
import com.example.electricitybillingsystem.service.implementation.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping()
    public List<AddressDto> getAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressDto getAddressById(@PathVariable("id") Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping()
    public void saveAddress(@RequestBody AddressDto addressDto) {
        addressService.save(addressDto);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable("id") Long addressId, @RequestBody AddressDto addressDto) {
        addressService.update(addressId, addressDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }
}
