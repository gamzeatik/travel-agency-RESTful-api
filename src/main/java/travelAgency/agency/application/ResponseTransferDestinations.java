package travelAgency.agency.application;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResponseTransferDestinations {
    UUID id;
    String name;
    String code;
    String address;
}
