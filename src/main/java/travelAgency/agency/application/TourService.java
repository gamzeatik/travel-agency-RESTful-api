package travelAgency.agency.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travelAgency.agency.domain.Tour;
import travelAgency.agency.domain.TourRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Transactional
    public Tour createTour(CreateTourDto tour) {
        var result = new Tour(
                UUID.randomUUID(),
                tour.getName(),
                tour.getDescription(),
                tour.getFromLocation(),
                tour.getToLocation(),
                tour.getStartDate(),
                tour.getEndDate(),
                tour.getPrice()
        );
        return tourRepository.save(result);
    }

    public List<Tour> getTourList() {
        return tourRepository.findAll().stream().toList();
    }

    public Tour getTour(UUID uuid) {
        return tourRepository.findById(uuid).orElse(null);
    }

    public void deleteTour(UUID uuid) {
        tourRepository.deleteById(uuid);
    }

    public Tour updateTour(UpdateTourDto tour) {
        var founded = tourRepository.findById(tour.getId());
        if (founded.isPresent()) {
            founded.get().setName(tour.getName());
            founded.get().setDescription(tour.getDescription());
            founded.get().setFromLocation(tour.getFromLocation());
            founded.get().setToLocation(tour.getToLocation());
            founded.get().setStartDate(tour.getStartDate());
            founded.get().setEndDate(tour.getEndDate());
            founded.get().setPrice(tour.getPrice());
            return tourRepository.save(founded.get());
        }
        return null;
    }
}
