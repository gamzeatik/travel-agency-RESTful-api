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

    public TransferDestinations(UUID id, String name, String code, String address) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
    }
}
