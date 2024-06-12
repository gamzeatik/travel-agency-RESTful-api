package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.RoundTripTransferDto;
import travelAgency.agency.application.TransferService;

import java.util.UUID;

@CrossOrigin(origins = "https://www.comfortabletransfer.com")
@RestController
@RequestMapping("/list")
public class TransferListController {
    private final TransferService transferService;

    public TransferListController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public RoundTripTransferDto getTransfers(@RequestParam String from, @RequestParam String to, @RequestParam boolean isRoundTrip, @RequestParam(required = false) int searchPax) {
        if (isRoundTrip) {
            return transferService.roundTripTransfer(UUID.fromString(from), UUID.fromString(to), searchPax);
        } else
            return transferService.oneWayTransfer(UUID.fromString(from), UUID.fromString(to), searchPax);
    }
}
