package travelAgency.agency.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Token {
    @Id
    private UUID id;
    public String token;
    @Enumerated(EnumType.STRING)
    public TokenType tokenType;
    public boolean revoked;
    public boolean expired;
    public UUID userId;

    public enum TokenType {
        BEARER
    }
}

