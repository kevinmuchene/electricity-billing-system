package com.example.electricitybillingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeterReading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int meterReading;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "PROPERTY_ID", referencedColumnName = "id")
    private Property property;
}
