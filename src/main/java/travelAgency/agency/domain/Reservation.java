package travelAgency.agency.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;
    private UUID firstTransferId;
    private UUID secondTransferId;
    private String flightNumber;
    private String note;
    private UUID tourId;
    private OffsetDateTime createAt;


    @ManyToMany
    @JoinTable(
            name = "reservation_customer",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers;

    public enum ReservationType {
        Tour,
        Transfer
    }

    public Reservation(UUID id, ReservationType reservationType, UUID firstTransferId, UUID secondTransferId, String flightNumber, String note, UUID tourId) {
        this.id = id;
        this.reservationType = reservationType;
        this.firstTransferId = firstTransferId;
        this.secondTransferId = secondTransferId;
        this.flightNumber = flightNumber;
        this.note = note;
        this.tourId = tourId;
        this.createAt = OffsetDateTime.now();
    }
}
