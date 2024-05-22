package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateTransferDto {
    UUID fromDestination;
    String fromDestinationName;
    UUID toDestination;
    String toDestinationName;
    Double price;
    UUID vehicle;
    OffsetDateTime pickupDate;
}
