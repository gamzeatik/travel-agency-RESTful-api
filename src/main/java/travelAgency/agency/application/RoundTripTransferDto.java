package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RoundTripTransferDto {
    List<TransferDto> onwardJourney;
    List<TransferDto> returnJourney;
}