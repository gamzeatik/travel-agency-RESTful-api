package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.CreateReservationDto;
import travelAgency.agency.application.ReservationService;
import travelAgency.agency.domain.Reservation;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation-list")
    public List<Reservation> getReservationList() {
        return reservationService.getReservationList();
    }

    @PostMapping("/post-reservation")
    public ReservationService.ReservationResult createReservation(@RequestBody CreateReservationDto reservation) {
        return reservationService.createReservation(reservation);
    }
}
