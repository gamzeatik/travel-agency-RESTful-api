package travelAgency.agency.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Transfer {
    @Id
    private UUID id;

    private UUID fromDestination;
    private String fromDestinationName;

    private UUID toDestination;
    private String toDestinationName;
    private Double price;

    private UUID vehicle;
    private OffsetDateTime pickupDate;

    public Transfer(UUID id, UUID fromDestination, String fromDestinationName, UUID toDestination, String toDestinationName, Double price, UUID vehicle, OffsetDateTime pickupDate) {
        this.id = id;
        this.fromDestination = fromDestination;
        this.fromDestinationName = fromDestinationName;
        this.toDestination = toDestination;
        this.toDestinationName = toDestinationName;
        this.price = price;
        this.vehicle = vehicle;
        this.pickupDate = pickupDate;
    }
}
