package com.vc.boot.service;

import com.vc.boot.bo.VehicleBo;
import com.vc.boot.entity.VehicleEntity;
import com.vc.boot.repository.VehicleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleBo newVehicle(VehicleBo vehicleBo) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        BeanUtils.copyProperties(vehicleBo, vehicleEntity);
        VehicleEntity VehicleEntityOut = vehicleRepository.save(vehicleEntity);
        VehicleBo vehicleBoOut = new VehicleBo();
        BeanUtils.copyProperties(VehicleEntityOut, vehicleBoOut);
        return vehicleBoOut;
    }

    public VehicleBo getVehicle(String vehicleName, String riderName) {
        VehicleEntity vehicleEntity = vehicleRepository.findVehicleEntityByVehicleNameAndRiderName(vehicleName, riderName);
        VehicleBo vehicleBo = new VehicleBo();
        BeanUtils.copyProperties(vehicleEntity, vehicleBo);
        return vehicleBo;
    }

    public VehicleBo getVehicleForRide() {
        List<VehicleEntity> vehicleEntity = vehicleRepository.findAll();
        VehicleBo vehicleBo = new VehicleBo();
        BeanUtils.copyProperties(vehicleEntity.getFirst(), vehicleBo);
        return vehicleBo;
    }
}
