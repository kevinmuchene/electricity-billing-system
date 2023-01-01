package com.example.electricitybillingsystem.controller;

import com.example.electricitybillingsystem.entity.dto.request.PropertyReqDto;
import com.example.electricitybillingsystem.entity.dto.response.CustomerDto;
import com.example.electricitybillingsystem.entity.dto.response.PropertyDto;
import com.example.electricitybillingsystem.service.implementation.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyServiceImpl propertyService;

    @GetMapping()
    public List<PropertyDto> getProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public PropertyDto getPropertyById(@PathVariable("id") Long id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping()
    public void saveProperty(@RequestBody PropertyReqDto propertyReqDto) {
        propertyService.save(propertyReqDto);
    }

    @PutMapping("/{id}")
    public void updateProperty(@PathVariable("id") Long propertyId, @RequestBody PropertyDto propertyDto){
        propertyService.update(propertyId, propertyDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable("id") Long id) {
        propertyService.delete(id);
    }
}
