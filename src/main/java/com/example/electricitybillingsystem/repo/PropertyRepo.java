package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Long> {

     List<Property> findAll();

     Property findPropertyById(Long id);

     Property findPropertyByCustomerId(Long id);

     List<Property> findPropertyByAddressId(Long id);

     void deleteById(Long propertyId);

}
