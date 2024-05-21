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
    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
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
}
