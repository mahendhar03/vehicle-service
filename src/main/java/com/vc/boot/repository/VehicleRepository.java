package com.vc.boot.repository;

import com.vc.boot.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
    public VehicleEntity findVehicleEntityByVehicleNameAndRiderName(String vehicleName, String riderName);
}
