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
public class ContactMessage {
    @Id
    private UUID id;
    private String subject;
    private String message;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private OffsetDateTime sentAt;

    public ContactMessage(String subject, String message, String name, String surname, String phone, String email) {
        this.id = UUID.randomUUID();
        this.subject = subject;
        this.message = message;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.sentAt = OffsetDateTime.now();
    }
}
