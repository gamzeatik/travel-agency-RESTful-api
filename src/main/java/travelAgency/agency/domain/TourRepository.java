package travelAgency.agency.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TourRepository extends JpaRepository<Tour, UUID> {
    @Query("""
            select t from Tour t
            where t.name ilike :query
            or t.description ilike :query
            or t.fromLocation ilike :query
            or t.toLocation ilike :query
            """)
    Optional<List<Tour>> search(String query);
}
