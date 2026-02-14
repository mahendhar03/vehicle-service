package com.vc.boot.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "VEHICLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;
    private String vehicleName;
    private String vehicleType;
    private String vehicleColor;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleEngine;
    private String riderName;
}
