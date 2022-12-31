package com.example.electricitybillingsystem.service.implementation;

import com.example.electricitybillingsystem.entity.Bill;
import com.example.electricitybillingsystem.entity.dto.response.BillDto;
import com.example.electricitybillingsystem.repo.BillRepo;
import com.example.electricitybillingsystem.service.BillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BillDto> getAllBills() {

        var bills = billRepo.findAll();

        return bills
                .stream()
                .map(bill -> modelMapper.map(bill, BillDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BillDto findBillById(Long id) {

        return modelMapper
                .map(billRepo.findBillById(id), BillDto.class);
    }

    @Override
    public List<BillDto> findBillByDate(Date date) {

        var bills = billRepo.findBillByDate(date);

        return bills
                .stream()
                .map(bill -> modelMapper.map(bill, BillDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BillDto> findBillByProperty_Id(Long id) {

        var bills = billRepo.findBillByProperty_Id(id);

        return bills
                .stream()
                .map(bill -> modelMapper.map(bill, BillDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(BillDto billDto) {
        billRepo.save(modelMapper.map(billDto, Bill.class));
    }

    @Override
    public BillDto update(Long billId, BillDto billDto) {

        Bill bill = billRepo.findBillById(billId);

        if(billDto.getReading() < 0) {
            bill.setReading(billDto.getReading());
        }

        if(billDto.getDate() != null) {
            bill.setDate(billDto.getDate());
        }

        billRepo.save(bill);

        return modelMapper.map(bill, BillDto.class);
    }

    @Override
    public void delete(Long billId) {
        billRepo.deleteBillById(billId);
    }
}
