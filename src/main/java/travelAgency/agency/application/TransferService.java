package travelAgency.agency.application;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import travelAgency.agency.domain.*;

import java.util.ArrayList;
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
                transfer.getFromDestinationName(),
                transfer.getToDestination(),
                transfer.getToDestinationName(),
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
                transfer.getId(),
                fromDestination.getName(),
                toDestination.getName(),
                transfer.getPickupDate(),
                vehicle.getType(),
                vehicle.getCarImage(),
                vehicle.getPax(),
                "Estimated Time",
                transfer.getPrice());
    }

    public RoundTripTransferDto oneWayTransfer(UUID from, UUID to) {
        var fromDestination = transferDestinationsRepository.findById(from).orElse(null);
        var toDestination = transferDestinationsRepository.findById(to).orElse(null);
        if (fromDestination == null || toDestination == null) {
            return null;
        } else {
            List<TransferDto> onwardJourneytList = new ArrayList<>();
            Optional<List<Transfer>> onwardJourney = transferRepository.listWithCriteria(fromDestination.getName(), toDestination.getName());
            if (onwardJourney.isPresent()) {
                for (Transfer t : onwardJourney.get()) {
                    var first = mapToDTO(t);
                    onwardJourneytList.add(first);
                }
            }
            return new RoundTripTransferDto(
                    onwardJourneytList,
                    null
            );
        }
    }

    public RoundTripTransferDto roundTripTransfer(UUID from, UUID to) {
        var fromDestination = transferDestinationsRepository.findById(from).orElse(null);
        var toDestination = transferDestinationsRepository.findById(to).orElse(null);

        if (fromDestination == null || toDestination == null) {
            return null;
        } else {
            List<TransferDto> onwardJourneytList = new ArrayList<>();
            List<TransferDto> returnJourneytList = new ArrayList<>();

            Optional<List<Transfer>> onwardJourney = transferRepository.listWithCriteria(fromDestination.getName(), toDestination.getName());
            Optional<List<Transfer>> returnJourney = transferRepository.listWithCriteria(toDestination.getName(),fromDestination.getName());

            if (onwardJourney.isPresent()) {
                for (Transfer t : onwardJourney.get()) {
                    var first = mapToDTO(t);
                    onwardJourneytList.add(first);
                }
            }
            if (returnJourney.isPresent()) {
                for (Transfer t : returnJourney.get()) {
                    var second = mapToDTO(t);
                    returnJourneytList.add(second);
                }
            }
            return new RoundTripTransferDto(onwardJourneytList, returnJourneytList);
        }
    }
}
