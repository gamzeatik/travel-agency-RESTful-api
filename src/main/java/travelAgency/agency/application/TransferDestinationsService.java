package travelAgency.agency.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travelAgency.agency.domain.TransferDestinations;
import travelAgency.agency.domain.TransferDestinationsRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TransferDestinationsService {
    public TransferDestinationsService(TransferDestinationsRepository transferDestinationsRepository) {
        this.transferDestinationsRepository = transferDestinationsRepository;
    }

    private final TransferDestinationsRepository transferDestinationsRepository;

    @Transactional
    public TransferDestinations createTransferDestinations(CreateTransferDestinationsDto transferDestinations) {
        var result = new TransferDestinations(
                UUID.randomUUID(),
                transferDestinations.getName(),
                transferDestinations.getCode(),
                transferDestinations.getAddress(),
                transferDestinations.getLatitude(),
                transferDestinations.getLongitude()
        );
        return transferDestinationsRepository.save(result);
    }

    public List<TransferDestinations> getTransferDestinationList() {
        return transferDestinationsRepository.findAll().stream().toList();
    }

    public TransferDestinations getTransferDestination(UUID uuid) {
        return transferDestinationsRepository.findById(uuid).orElse(null);
    }

    @Transactional
    public void deleteTransferDestination(UUID uuid) {
        transferDestinationsRepository.deleteById(uuid);
    }
}
