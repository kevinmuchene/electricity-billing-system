package com.example.electricitybillingsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "id")
    private Customer customer;

//    @ManyToOne(optional = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id")
    @JsonIgnore
    private Address address;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<Bill> bills;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<MeterReading> meterReadings;


//    private Address address_id;
//    private MeterReading meterReading_id;
}
