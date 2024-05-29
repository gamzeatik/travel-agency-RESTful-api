package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.CreateTransferDto;
import travelAgency.agency.application.TransferService;
import travelAgency.agency.domain.Transfer;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/post-transfer")
    public Transfer createTransfer(@RequestBody CreateTransferDto transfer) {
        return transferService.createTransfer(transfer);
    }

    @GetMapping("/transfer-list")
    public List<Transfer> getTransferList() {
        return transferService.getTransferList();
    }

    @GetMapping("/transfer/{id}")
    public Transfer getTransfer(@PathVariable String id) {
        return transferService.getTransfer(UUID.fromString(id));
    }

    @DeleteMapping("/delete-transfer/{id}")
    public void deleteTransfer(@PathVariable String id) {
        transferService.deleteTransfer(UUID.fromString(id));
    }

}
