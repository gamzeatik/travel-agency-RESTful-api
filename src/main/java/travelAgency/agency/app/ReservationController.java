package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.CreateReservationDto;
import travelAgency.agency.application.ReservationService;

@CrossOrigin(origins = "https://www.comfortabletransfer.com")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation-list")
    public ReservationService.ReservationListResult getReservationList() {
        return reservationService.getReservationList();
    }

    @PostMapping("/post-reservation")
    public ReservationService.CreatedReservationResult createReservation(@RequestBody CreateReservationDto reservation) {
        return reservationService.createReservation(reservation);
    }
}
