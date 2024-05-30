package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateCustomerDto {
    private String firstName;
    private String lastName;
    private String passengerFullName;
    private String email;
    private String phone;
    private String address;
    private String nationality;
}
