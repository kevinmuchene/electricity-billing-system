package com.example.electricitybillingsystem.service;

import com.example.electricitybillingsystem.entity.Customer;
import com.example.electricitybillingsystem.entity.dto.response.PropertyDto;

import java.util.List;

public interface PropertyService {

    List<PropertyDto> getAllProperties();

    PropertyDto getPropertyById(Long id);

    PropertyDto getPropertyByCustomerId(Long id);

    List<PropertyDto> getPropertyByAddressId(Long id);
}
