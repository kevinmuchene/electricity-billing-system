package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Property;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepo extends CrudRepository<Property, Long> {

    public List<Property> findByAll();

    public Property findById(Integer id);

    public List<Property> findByCustomerDrivingLicence(Integer drivingLicence);

    public List<Property> findByCustomerId(Integer id);

    public List<Property> findByState(String state);


}
