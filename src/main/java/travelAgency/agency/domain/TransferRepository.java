package travelAgency.agency.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
    Optional<Transfer> findByFromDestinationAndToDestinationAndPickupDate(UUID fromDestination, UUID toDestination, OffsetDateTime pickupDate);

}
