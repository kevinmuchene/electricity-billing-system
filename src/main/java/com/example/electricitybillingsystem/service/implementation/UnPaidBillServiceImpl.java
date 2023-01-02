package com.example.electricitybillingsystem.service.implementation;

import com.example.electricitybillingsystem.entity.UnPaidBills;
import com.example.electricitybillingsystem.entity.dto.request.UnPaidBillsReqDto;
import com.example.electricitybillingsystem.entity.dto.response.UnPaidBillsDto;
import com.example.electricitybillingsystem.repo.UnPaidBillRepo;
import com.example.electricitybillingsystem.service.UnPaidBillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnPaidBillServiceImpl implements UnPaidBillService {

    @Autowired
    private UnPaidBillRepo unPaidBillRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UnPaidBillsReqDto> findAll() {
       var unPaidBills = unPaidBillRepo.findAll();

       return unPaidBills
               .stream()
               .map(unPaidBill -> modelMapper.map(unPaidBill, UnPaidBillsReqDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public UnPaidBillsDto findUnPaidBillsByPropertyId(Long id) {
        return modelMapper.map(unPaidBillRepo.findUnPaidBillsById(id), UnPaidBillsDto.class);
    }

    @Override
    public void save(UnPaidBillsDto unPaidBillsDto) {
        unPaidBillRepo.save(modelMapper.map(unPaidBillsDto, UnPaidBills.class));
    }

    @Override
    public UnPaidBillsDto update(Long paidBillsId, UnPaidBillsDto unPaidBillsDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        unPaidBillRepo.deleteById(id);
    }
}
