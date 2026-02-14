package com.vc.boot.controller;

import com.vc.boot.bo.VehicleBo;
import com.vc.boot.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(value = "/new")
    public VehicleBo newVehicle(@RequestBody VehicleBo vehicleBo) {
        return vehicleService.newVehicle(vehicleBo);
    }

    @GetMapping(value = "/{vehicleName}/rider/{riderName}")
    public VehicleBo getVehicle(@PathVariable("vehicleName") String vehicleName, @PathVariable("riderName") String riderName){
        return vehicleService.getVehicle(vehicleName, riderName);
    }

    @GetMapping(value = "/ride")
    public VehicleBo getVehicleForRide(){
        return vehicleService.getVehicleForRide();
    }
}
