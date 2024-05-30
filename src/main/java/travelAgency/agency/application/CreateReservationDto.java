package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import travelAgency.agency.domain.Reservation;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateReservationDto {
    String firstName;
    String lastName;
    String email;
    String phone;
    String address;
    Reservation.ReservationType reservationType;
    UUID firstTransferId;
    UUID secondTransferId;
    UUID tourId;
}
