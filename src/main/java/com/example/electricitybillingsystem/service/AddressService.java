package com.example.electricitybillingsystem.service;

import com.example.electricitybillingsystem.entity.dto.response.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAllAddresses();

    AddressDto getAddressById(Long id);
}
