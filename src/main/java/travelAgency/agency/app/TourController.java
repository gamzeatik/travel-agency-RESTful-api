package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.CreateTourDto;
import travelAgency.agency.application.TourService;
import travelAgency.agency.application.UpdateTourDto;
import travelAgency.agency.domain.Tour;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "https://www.comfortabletransfer.com")
@RestController
@RequestMapping("/tours")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping
    public Tour createTour(@RequestBody CreateTourDto tour) {
        return tourService.createTour(tour);
    }

    @GetMapping("/tour-list")
    public List<Tour> getTourList() {
        return tourService.getTourList();
    }

    @GetMapping("/tour/{id}")
    public Tour getTour(@PathVariable String id) {
        return tourService.getTour(UUID.fromString(id));
    }

    @DeleteMapping("/delete-tour/{id}")
    public void deleteTour(@PathVariable String id) {
        tourService.deleteTour(UUID.fromString(id));
    }

    @PutMapping("/update-tour")
    public Tour updateTour(@RequestBody UpdateTourDto tour) {
        return tourService.updateTour(tour);
    }
//    @GetMapping("/search-tours")
//    public List<Tour> searchTours(@RequestParam(required = false) String query){
//        return tourService.searchTours(query);
//    }
}
