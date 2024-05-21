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
    private UUID transferId;
    private UUID tourId;
    private OffsetDateTime createAt;


    public enum ReservationType {
        Tour,
        Transfer
    }

    public Reservation(String firstName, String lastName, String email, String phone, String address, ReservationType reservationType, UUID transferId, UUID tourId, OffsetDateTime createAt) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.reservationType = reservationType;
        this.transferId = transferId;
        this.tourId = tourId;
        this.createAt = createAt;
    }
}
