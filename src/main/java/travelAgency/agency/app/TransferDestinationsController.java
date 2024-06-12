package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.CreateTransferDestinationsDto;
import travelAgency.agency.application.ResponseTransferDestinations;
import travelAgency.agency.application.TransferDestinationsService;
import travelAgency.agency.domain.TransferDestinations;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "https://www.comfortabletransfer.com")
@RestController
@RequestMapping("/transfer-destinations")
public class TransferDestinationsController {
    private final TransferDestinationsService transferDestinationsService;

    public TransferDestinationsController(TransferDestinationsService transferDestinationsService) {
        this.transferDestinationsService = transferDestinationsService;
    }

    @PostMapping("/post-transfer-destinations")
    public TransferDestinations createTransferDestinations(@RequestBody CreateTransferDestinationsDto transferDestinations) {
        return transferDestinationsService.createTransferDestinations(transferDestinations);
    }

    @GetMapping("/transfer-destinations-list")
    public List<ResponseTransferDestinations> getTransferDestinationsList() {
        return transferDestinationsService.getTransferDestinationList();
    }

    @GetMapping("/transfer-destination/{id}")
    public ResponseTransferDestinations getTransferDestination(@PathVariable String id) {
        return transferDestinationsService.getTransferDestination(UUID.fromString(id));
    }

    @DeleteMapping("/delete-transfer-destination/{id}")
    public void deleteTransferDestination(@PathVariable String id) {
        transferDestinationsService.deleteTransferDestination(UUID.fromString(id));
    }
}
