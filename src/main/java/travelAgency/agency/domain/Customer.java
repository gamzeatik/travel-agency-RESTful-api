package travelAgency.agency.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String passengerFullName;
    private String email;
    private String phone;
    private String address;
    private String nationality;

    @ManyToMany(mappedBy = "customers")
    private Set<Reservation> reservations;

    public Customer(UUID id, String firstName, String lastName, String passengerFullName, String email, String phone, String address, String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passengerFullName = passengerFullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.nationality = nationality;
    }
}
