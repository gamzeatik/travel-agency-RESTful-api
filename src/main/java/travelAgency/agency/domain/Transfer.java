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

    private UUID toDestination;
    private Double price;

    private UUID vehicle;
    private OffsetDateTime pickupDate;

    public Transfer(UUID id, UUID fromDestination, UUID toDestination, Double price, UUID vehicle, OffsetDateTime pickupDate) {
        this.id = id;
        this.fromDestination = fromDestination;
        this.toDestination = toDestination;
        this.price = price;
        this.vehicle = vehicle;
        this.pickupDate = pickupDate;
    }
}
