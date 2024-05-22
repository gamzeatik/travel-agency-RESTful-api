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
    UUID toDestination;
    Double price;
    UUID vehicle;
    OffsetDateTime pickupDate;
}
