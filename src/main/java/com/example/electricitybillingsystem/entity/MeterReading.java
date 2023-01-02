package com.example.electricitybillingsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @PrePersist
    private void onCreate() {
        date = new Date();
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROPERTY_ID", referencedColumnName = "id")
    @JsonBackReference
    private Property property;
}
