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
    public Vehicle createVehicle(CreateVehicleDto vehicle) {
        var result = new Vehicle(
                UUID.randomUUID(),
                vehicle.name,
                vehicle.carImage,
                vehicle.pax,
                vehicle.isVip,
                vehicle.type,
                vehicle.price,
                vehicle.description,
                vehicle.luggageAllowance
        );
        vehicleRepository.save(result);
        return result;
    }

    public Vehicle getVehicle(UUID uuid) {
        return vehicleRepository.findById(uuid).orElse(null);
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        var foundedVehicle = vehicleRepository.findById(vehicle.getId()).orElse(null);
        if (foundedVehicle != null) {
            foundedVehicle.setName(vehicle.getName());
            foundedVehicle.setCarImage(vehicle.getCarImage());
            foundedVehicle.setPax(vehicle.getPax());
            foundedVehicle.setVip(vehicle.isVip());
            foundedVehicle.setType(vehicle.getType());
            foundedVehicle.setPrice(vehicle.getPrice());
            foundedVehicle.setDescription(vehicle.getDescription());
            foundedVehicle.setLuggageAllowance(vehicle.getLuggageAllowance());
            return vehicleRepository.save(foundedVehicle);
        }
        return null;
    }

    public void deleteVehicle(UUID uuid) {
        vehicleRepository.deleteById(uuid);
    }
}
