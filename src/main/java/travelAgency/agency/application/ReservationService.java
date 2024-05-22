package travelAgency.agency.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travelAgency.agency.domain.Reservation;
import travelAgency.agency.domain.ReservationRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional(readOnly = true)
    public List<Reservation> getReservationList() {
        return reservationRepository.findAll();
    }

    public record ReservationResult(UUID reservationId, String message) {
    }

    @Transactional
    public ReservationResult createReservation(CreateReservationDto reservation) {
        try {
            var result = new Reservation(
                    UUID.randomUUID(),
                    reservation.getFirstName(),
                    reservation.getLastName(),
                    reservation.getEmail(),
                    reservation.getPhone(),
                    reservation.getAddress(),
                    reservation.getReservationType(),
                    reservation.getTransferId(),
                    reservation.getTransferId()
            );
            var res = reservationRepository.save(result);
            return new ReservationResult(res.getId(), "Reservation created!");
        } catch (Exception e) {
            return new ReservationResult(null, "Error while creating reservation!");
        }
    }
}
