package com.example.electricitybillingsystem.entity.dto.request;

import com.example.electricitybillingsystem.entity.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropertyReqDto {
        private Long id;
        private Long customerId;
        private String type;
        private Address address;
}
