package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepo extends CrudRepository<Address, Long> {

    public List<Address> findAll();

    public Address findByAddressId(Long id);
}
