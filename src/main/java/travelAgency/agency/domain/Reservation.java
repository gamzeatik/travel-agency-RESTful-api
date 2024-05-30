package travelAgency.agency.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Reservation {
    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;
    private UUID firstTransferId;
    private UUID secondTransferId;
    private UUID tourId;
    private OffsetDateTime createAt;


    public enum ReservationType {
        Tour,
        Transfer
    }

    public Reservation(UUID id, String firstName, String lastName, String email, String phone, String address, ReservationType reservationType, UUID firstTransferId, UUID secondTransferId, UUID tourId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.reservationType = reservationType;
        this.firstTransferId = firstTransferId;
        this.secondTransferId = secondTransferId;
        this.tourId = tourId;
        this.createAt = OffsetDateTime.now();
    }
}
