package com.example.electricitybillingsystem.repo;

import com.example.electricitybillingsystem.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {

      List<Address> findAll();

      Address findAddressById(Long id);

      void deleteAddressById(Long addressId);
}
