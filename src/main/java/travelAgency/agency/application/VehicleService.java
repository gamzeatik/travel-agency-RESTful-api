package travelAgency.agency.application;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import travelAgency.agency.domain.Vehicle;
import travelAgency.agency.domain.VehicleRepository;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleRepository.findAll().stream().toList();
    }

    @Transactional
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicle(UUID uuid) {
        return vehicleRepository.findById(uuid).orElse(null);
    }
}
