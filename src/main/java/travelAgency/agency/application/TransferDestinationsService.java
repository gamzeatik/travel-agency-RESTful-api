package travelAgency.agency.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travelAgency.agency.domain.TransferDestinations;
import travelAgency.agency.domain.TransferDestinationsRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransferDestinationsService {
    public TransferDestinationsService(ModelMapperServices modelMapperServices, TransferDestinationsRepository transferDestinationsRepository) {
        this.modelMapperServices = modelMapperServices;
        this.transferDestinationsRepository = transferDestinationsRepository;
    }

    private final ModelMapperServices modelMapperServices;
    private final TransferDestinationsRepository transferDestinationsRepository;

    @Transactional
    public TransferDestinations createTransferDestinations(CreateTransferDestinationsDto transferDestinations) {
        var result = new TransferDestinations(
                UUID.randomUUID(),
                transferDestinations.getName(),
                transferDestinations.getCode(),
                transferDestinations.getAddress()
        );
        return transferDestinationsRepository.save(result);
    }

    public List<ResponseTransferDestinations> getTransferDestinationList() {
        List<TransferDestinations> transferDestinations = transferDestinationsRepository.findAll().stream().toList();
        return transferDestinations.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public ResponseTransferDestinations getTransferDestination(UUID uuid) {
        TransferDestinations transferDestinations = transferDestinationsRepository.findById(uuid).orElse(null);
        return mapToResponse(transferDestinations);
    }

    @Transactional
    public void deleteTransferDestination(UUID uuid) {
        transferDestinationsRepository.deleteById(uuid);
    }

    private ResponseTransferDestinations mapToResponse(TransferDestinations destinations) {
        return modelMapperServices.forResponse().map(destinations, ResponseTransferDestinations.class);
    }
}
