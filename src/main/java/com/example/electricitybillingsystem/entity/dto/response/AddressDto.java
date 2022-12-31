package com.example.electricitybillingsystem.entity.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String state;
    private String county;
    private String town;
}
