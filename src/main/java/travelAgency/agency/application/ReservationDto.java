package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import travelAgency.agency.domain.Reservation;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ReservationDto {
    private UUID id;
    private Reservation.ReservationType reservationType;
    private UUID firstTransferId;
    private UUID secondTransferId;
    private String flightNumber;
    private String note;
    private UUID tourId;
    private Set<CustomerDto> customers;
}
