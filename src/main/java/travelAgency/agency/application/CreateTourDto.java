package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CreateTourDto {
    String name;
    String description;
    String fromLocation;
    String toLocation;
    OffsetDateTime startDate;
    OffsetDateTime endDate;
    Double price;
}
