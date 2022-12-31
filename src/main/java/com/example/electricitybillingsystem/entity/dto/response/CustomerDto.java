package com.example.electricitybillingsystem.entity.dto.response;

import com.example.electricitybillingsystem.entity.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer licence;
//    private Address address;
}
