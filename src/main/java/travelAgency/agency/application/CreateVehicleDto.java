package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateVehicleDto {
    String name;
    String carImage;
    int pax;
    boolean isVip;
    String type;
    Double price;
    String description;
    int luggageAllowance;
}
