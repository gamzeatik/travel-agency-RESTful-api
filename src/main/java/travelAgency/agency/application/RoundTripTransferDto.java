package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoundTripTransferDto {
    private TransferDto onwardJourney;
    private TransferDto returnJourney;
}