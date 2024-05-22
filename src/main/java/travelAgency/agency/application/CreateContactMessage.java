package travelAgency.agency.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateContactMessage {
    String subject;
    String message;
    String name;
    String surname;
    String phone;
    String email;
}
