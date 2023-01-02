package com.example.electricitybillingsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String state;
    private String county;
    private String town;

    @OneToMany(mappedBy = "address")

    public List<Property> properties;

    @OneToMany(mappedBy = "address")
    public List<Customer> customers;
}
