package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TransferDTO {
    private String fromDestination;
    private String toDestination;
    private OffsetDateTime pickupDate;
    private String vehicleType;
    private String vehicleImage;
    private int paxCount;
    private String estimatedTime;
    private Double price;
    private boolean isRoundTrip;
}
