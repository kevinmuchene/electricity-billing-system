package com.example.electricitybillingsystem.service.implementation;

import com.example.electricitybillingsystem.entity.PaidBills;
import com.example.electricitybillingsystem.entity.Property;
import com.example.electricitybillingsystem.entity.dto.response.PaidBillsDto;
import com.example.electricitybillingsystem.repo.PaidBillRepo;
import com.example.electricitybillingsystem.service.PaidBillsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaidBillsServiceImpl implements PaidBillsService {

    @Autowired
    private PaidBillRepo paidBillRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PaidBillsDto> findAll() {
        var paidBills = paidBillRepo.findAll();

        return paidBills
                .stream()
                .map(paidBill -> modelMapper.map(paidBill, PaidBillsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaidBillsDto findPaidBillsByPropertyId(Long id) {

        return modelMapper.map(paidBillRepo.findPaidBillsById(id), PaidBillsDto.class);
    }

    @Override
    public void save(PaidBillsDto paidBillsDto) {
        paidBillRepo.save(modelMapper.map(paidBillsDto, PaidBills.class));
    }

    @Override
    public PaidBillsDto update(Long paidBillsId, PaidBillsDto paidBillsDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        paidBillRepo.deleteById(id);
    }
}
