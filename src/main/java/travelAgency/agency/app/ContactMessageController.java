package travelAgency.agency.app;

import org.springframework.web.bind.annotation.*;
import travelAgency.agency.application.ContactMessageService;
import travelAgency.agency.application.CreateContactMessage;
import travelAgency.agency.domain.ContactMessage;

import java.util.List;

@CrossOrigin(origins = "https://www.comfortabletransfer.com")
@RestController
@RequestMapping("/contact-us")
public class ContactMessageController {
    private final ContactMessageService contactMessageService;

    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @GetMapping("/message-list")
    public List<ContactMessage> getMessageList() {
        return contactMessageService.getMessageList();
    }

    @PostMapping("/post-contact-us")
    public String createMessage(@RequestBody CreateContactMessage contactMessage) {
        return contactMessageService.createMessage(contactMessage);
    }
}
