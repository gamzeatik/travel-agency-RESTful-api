package travelAgency.agency.application;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import travelAgency.agency.domain.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransferService {
    private final TransferRepository transferRepository;
    private final VehicleRepository vehicleRepository;
    private final TransferDestinationsRepository transferDestinationsRepository;

    public TransferService(TransferRepository transferRepository, VehicleRepository vehicleRepository, TransferDestinationsRepository transferDestinationsRepository) {
        this.transferRepository = transferRepository;
        this.vehicleRepository = vehicleRepository;
        this.transferDestinationsRepository = transferDestinationsRepository;
    }

    @Transactional
    public Transfer createTransfer(CreateTransferDto transfer) {
        var result = new Transfer(
                UUID.randomUUID(),
                transfer.getFromDestination(),
                transfer.getToDestination(),
                transfer.getPrice(),
                transfer.getVehicle(),
                transfer.getPickupDate()
        );
        return transferRepository.save(result);
    }

    public List<Transfer> getTransferList() {
        return transferRepository.findAll().stream().toList();
    }

    public Transfer getTransfer(UUID uuid) {
        return transferRepository.findById(uuid).orElse(null);
    }

    @Transactional
    public void deleteTransfer(UUID uuid) {
        transferRepository.deleteById(uuid);
    }

    public TransferDto mapToDTO(Transfer transfer) {
        TransferDestinations fromDestination = transferDestinationsRepository.findById(transfer.getFromDestination()).orElse(null);
        TransferDestinations toDestination = transferDestinationsRepository.findById(transfer.getToDestination()).orElse(null);
        Vehicle vehicle = vehicleRepository.findById(transfer.getVehicle()).orElse(null);

        if (fromDestination == null || toDestination == null || vehicle == null) {
            return null;
        }

        return new TransferDto(
                fromDestination.getName(),
                toDestination.getName(),
                transfer.getPickupDate(),
                vehicle.getType(),
                vehicle.getCarImage(),
                vehicle.getPax(),
                "Estimated Time",
                transfer.getPrice());
    }

    public RoundTripTransferDto searchOneWay(UUID from, UUID to, OffsetDateTime date) {
        Optional<Transfer> transfer = transferRepository.findByFromDestinationAndToDestinationAndPickupDate(from, to, date);
        var result = transfer.map(this::mapToDTO).orElse(null);
        return new RoundTripTransferDto(
                result,
                null
        );
    }

    public RoundTripTransferDto searchRoundTrip(UUID from, UUID to, OffsetDateTime onwardDate, OffsetDateTime returnDate) {
        Optional<Transfer> onwardJourney = transferRepository.findByFromDestinationAndToDestinationAndPickupDate(from, to, onwardDate);
        Optional<Transfer> returnJourney = transferRepository.findByFromDestinationAndToDestinationAndPickupDate(from, to, returnDate);
        var first = onwardJourney.map(this::mapToDTO).orElse(null);
        var second = returnJourney.map(this::mapToDTO).orElse(null);

        return new RoundTripTransferDto(first, second);
    }
}
