package travelAgency.agency.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
    @Query("""
            select t from Transfer t
            where t.fromDestinationName ilike :fromDestinationName
            or t.toDestinationName ilike :toDestinationName
            """)
    Optional<List<Transfer>> search(String fromDestinationName, String toDestinationName);

}
