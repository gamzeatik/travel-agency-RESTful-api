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
public class Vehicle {
    @Id
    private UUID id;
    private String name;
    private String carImage;
    private int pax;
    private boolean isVip;
    private String type;
    private Double price;
    private String description;
    private int luggageAllowance;


    public Vehicle(UUID id,String name, String carImage, int pax, boolean isVip, String type, Double price, String description, int luggageAllowance) {
        this.id = id;
        this.name = name;
        this.carImage = carImage;
        this.pax = pax;
        this.isVip = isVip;
        this.type = type;
        this.price = price;
        this.description = description;
        this.luggageAllowance = luggageAllowance;
    }
}
