package travelAgency.agency.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travelAgency.agency.domain.Customer;
import travelAgency.agency.domain.CustomerRepository;
import travelAgency.agency.domain.Reservation;
import travelAgency.agency.domain.ReservationRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    public ReservationService(ReservationRepository reservationRepository, CustomerRepository customerRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
    }

    public record ReservationListResult(List<ReservationDto> reservations, String message) {
    }

    @Transactional(readOnly = true)
    public ReservationListResult getReservationList() {
        var reslist = reservationRepository.findAll().stream()
                .map(this::convertToReservationDto)
                .collect(Collectors.toList());
        return new ReservationListResult(
                reslist,
                "Success"
        );
    }

    private ReservationDto convertToReservationDto(Reservation reservation) {
        Set<CustomerDto> customerDtos = reservation.getCustomers().stream()
                .map(this::convertToCustomerDto)
                .collect(Collectors.toSet());
        return new ReservationDto(
                reservation.getId(),
                reservation.getReservationType(),
                reservation.getFirstTransferId(),
                reservation.getSecondTransferId(),
                reservation.getFlightNumber(),
                reservation.getNote(),
                reservation.getTourId(),
                customerDtos
        );
    }

    private CustomerDto convertToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPassengerFullName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getNationality()
        );
    }

    public record CreatedReservationResult(UUID reservationId, String message) {
    }

    @Transactional
    public CreatedReservationResult createReservation(CreateReservationDto createReservationDto) {
        try {
            Set<Customer> customers = createReservationDto.getCustomer().stream()
                    .map(this::convertToCustomerEntity)
                    .collect(Collectors.toSet());
            customerRepository.saveAll(customers);


            Reservation reservation = new Reservation(
                    UUID.randomUUID(),
                    createReservationDto.getReservationType(),
                    createReservationDto.getFirstTransferId(),
                    createReservationDto.getSecondTransferId(),
                    createReservationDto.getFlightNumber(),
                    createReservationDto.getNote(),
                    createReservationDto.getTourId()
            );
            reservation.setCustomers(customers);
            var res = reservationRepository.save(reservation);

            return new CreatedReservationResult(res.getId(), "Reservation created!");
        } catch (Exception e) {
            return new CreatedReservationResult(null, "Error while creating reservation!");
        }
    }

    private Customer convertToCustomerEntity(CreateCustomerDto createCustomerDto) {
        return new Customer(
                UUID.randomUUID(),
                createCustomerDto.getFirstName(),
                createCustomerDto.getLastName(),
                createCustomerDto.getPassengerFullName(),
                createCustomerDto.getEmail(),
                createCustomerDto.getPhone(),
                createCustomerDto.getAddress(),
                createCustomerDto.getNationality()
        );
    }
}
