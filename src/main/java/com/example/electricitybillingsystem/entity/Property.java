package com.example.electricitybillingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private Long customer_id;
    private String type;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "property")
    private List<Bill> bills;

    @OneToMany(mappedBy = "property")
    private List<MeterReading> meterReadings;


//    private Address address_id;
//    private MeterReading meterReading_id;
}
