package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class TransferDto {
    UUID id;
    String fromDestination;
    String toDestination;
    OffsetDateTime pickupDate;
    String vehicleType;
    String vehicleImage;
    int paxCount;
    String estimatedTime;
    Double price;
}
