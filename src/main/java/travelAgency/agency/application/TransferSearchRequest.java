package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TransferSearchRequest {
    String from;
    String to;
    OffsetDateTime date;
    boolean isRoundTrip;
    OffsetDateTime returnDate;
}
