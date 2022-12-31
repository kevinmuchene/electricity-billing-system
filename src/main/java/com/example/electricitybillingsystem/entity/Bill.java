package com.example.electricitybillingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int reading;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "PROPERTY_ID", referencedColumnName = "id")
    private Property property;


}
