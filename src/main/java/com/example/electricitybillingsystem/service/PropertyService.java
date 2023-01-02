package com.example.electricitybillingsystem.service;

import com.example.electricitybillingsystem.entity.dto.request.PropertyReqDto;
import com.example.electricitybillingsystem.entity.dto.response.PropertyDto;

import java.util.List;

public interface PropertyService {

    List<PropertyDto> getAllProperties();

    PropertyDto getPropertyById(Long id);

    List<PropertyDto> getPropertyByCustomerId(Long id);

    List<PropertyDto> getPropertyByAddressId(Long id);

    void save(PropertyReqDto PropertyReqDto);

    PropertyDto update(Long propertyId, PropertyDto propertyDto);

    void delete(Long propertyId);
}
