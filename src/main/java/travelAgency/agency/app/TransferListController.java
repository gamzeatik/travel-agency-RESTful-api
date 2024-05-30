package travelAgency.agency.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import travelAgency.agency.application.RoundTripTransferDto;
import travelAgency.agency.application.TransferService;

import java.util.UUID;

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
