package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UpdateTourDto {
    UUID id;
    String name;
    String description;
    String fromLocation;
    String toLocation;
    OffsetDateTime startDate;
    OffsetDateTime endDate;
    Double price;
}
