package com.codingshuttle.project.uber.uberApp.entities;


import com.codingshuttle.project.uber.uberApp.entities.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String color;
    String plate;

    @Min(value = 1)
    int capacity;

    @Enumerated(EnumType.STRING)
    VehicleType vehicleType;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnoreProperties("vehicle")
    Driver driver;

}
