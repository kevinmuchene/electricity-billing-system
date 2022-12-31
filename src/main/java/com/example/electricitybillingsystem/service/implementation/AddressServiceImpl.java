package com.example.electricitybillingsystem.service.implementation;

import com.example.electricitybillingsystem.entity.Address;
import com.example.electricitybillingsystem.entity.dto.response.AddressDto;
import com.example.electricitybillingsystem.repo.AddressRepo;
import com.example.electricitybillingsystem.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<AddressDto> getAllAddresses() {

        var addresses = addressRepo.findAll();

        return addresses
                .stream()
                .map(address -> modelMapper.map(address, AddressDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto getAddressById(Long id) {

        return modelMapper
                .map(addressRepo.findAddressById(id), AddressDto.class);
    }

    @Override
    public void save(AddressDto addressDto) {
        addressRepo.save(modelMapper.map(addressDto, Address.class));
    }

    @Override
    public AddressDto update(Long addressId, AddressDto addressDto) {

        Address address = addressRepo.findAddressById(addressId);

        if(addressDto.getState() != null) {
            address.setState(addressDto.getState());
        }

        if(addressDto.getCounty() != null) {
            address.setCounty(addressDto.getCounty());
        }

        if(addressDto.getTown() != null) {
            address.setTown(addressDto.getTown());
        }

        addressRepo.save(address);

        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepo.deleteById(addressId);
    }
}
