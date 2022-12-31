package com.example.electricitybillingsystem.service.implementation;

import com.example.electricitybillingsystem.entity.Customer;

import com.example.electricitybillingsystem.entity.Property;
import com.example.electricitybillingsystem.entity.dto.response.PropertyDto;
import com.example.electricitybillingsystem.repo.PropertyRepo;
import com.example.electricitybillingsystem.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PropertyDto> getAllProperties() {

        var properties = propertyRepo.findAll();

        return properties
                .stream()
                .map(property -> modelMapper.map(property, PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDto getPropertyById(Long id) {

        return modelMapper
                .map(propertyRepo.findPropertyById(id), PropertyDto.class);
    }

    @Override
    public PropertyDto getPropertyByCustomerId(Long id) {
        return modelMapper
                .map(propertyRepo.findPropertyByCustomerId(id), PropertyDto.class);
    }

    @Override
    public List<PropertyDto> getPropertyByAddressId(Long id) {

        var properties = propertyRepo.findPropertyByAddressId(id);

        return properties
                .stream()
                .map(property -> modelMapper.map(property, PropertyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PropertyDto propertyDto) {
        propertyRepo.save(modelMapper.map(propertyDto, Property.class));
    }

    @Override
    public PropertyDto update(Long propertyId, PropertyDto propertyDto) {

        Property property = propertyRepo.findPropertyById(propertyId);

        if(propertyDto.getType() != null){
            property.setType(propertyDto.getType());
        }

        if(propertyDto.getAddress() != null){
            property.setAddress(propertyDto.getAddress());
        }

        propertyRepo.save(property);

        return modelMapper.map(property, PropertyDto.class);
    }

    @Override
    public void delete(Long propertyId) {
        propertyRepo.deletePropertyById(propertyId);
    }
}
