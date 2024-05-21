package travelAgency.agency.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}
