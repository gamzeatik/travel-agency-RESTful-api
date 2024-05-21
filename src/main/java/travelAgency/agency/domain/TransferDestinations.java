package travelAgency.agency.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class TransferDestinations {
    @Id
    private UUID id;
    private String name;
    private String code;
    private String address;
    private double latitude;
    private double longitude;

    public TransferDestinations(UUID id, String name, String code, String address, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
