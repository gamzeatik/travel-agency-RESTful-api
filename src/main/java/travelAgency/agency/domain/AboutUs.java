package travelAgency.agency.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AboutUs {
    @Id
    private UUID id;
    private String title;
    private String description;
    private boolean isActive = true;
    private OffsetDateTime createAt;

    public AboutUs(UUID id,String title, String description, boolean isActive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.createAt = OffsetDateTime.now();
    }
}
