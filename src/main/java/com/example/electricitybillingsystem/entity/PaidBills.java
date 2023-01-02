package com.example.electricitybillingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class PaidBills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double billReading;
    private Date date;

    @ManyToOne
    private Property property;
}
