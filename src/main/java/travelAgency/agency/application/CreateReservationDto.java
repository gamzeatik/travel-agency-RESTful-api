package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import travelAgency.agency.domain.Reservation;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateReservationDto {
    List<CreateCustomerDto> customer;
    Reservation.ReservationType reservationType;
    UUID firstTransferId;
    UUID secondTransferId;
    String flightNumber;
    String note;
    UUID tourId;
}
