package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.CreateVehicleDto;
import travelAgency.agency.application.VehicleService;
import travelAgency.agency.domain.Vehicle;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle-list")
    public List<Vehicle> getVehicleList() {
        return vehicleService.getVehicleList();
    }

    @PostMapping("/post-vehicle")
    public Vehicle createVehicle(@RequestBody CreateVehicleDto vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @GetMapping("/vehicle/{id}")
    public Vehicle getVehicle(@PathVariable String id) {
        return vehicleService.getVehicle(UUID.fromString(id));
    }
}
