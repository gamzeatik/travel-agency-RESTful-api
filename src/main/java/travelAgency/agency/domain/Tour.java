package travelAgency.agency.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
@Setter
public class Tour {
    @Id
    private UUID id;
    private String name;
    private String description;
    private String fromLocation;
    private String toLocation;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Double price;
    private String imageUrl;

    public Tour(UUID id, String name, String description, String fromLocation, String toLocation, OffsetDateTime startDate, OffsetDateTime endDate, Double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
