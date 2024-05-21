package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoundTripTransferDTO {
    private TransferDTO onwardJourney;
    private TransferDTO returnJourney;
}