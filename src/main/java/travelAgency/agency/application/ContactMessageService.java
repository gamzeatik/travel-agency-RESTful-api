package travelAgency.agency.application;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import travelAgency.agency.domain.ContactMessage;
import travelAgency.agency.domain.ContactMessageRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ContactMessageService {
    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public List<ContactMessage> getMessageList() {
        return contactMessageRepository.findAll().stream().toList();
    }

    @Transactional
    public String createMessage(CreateContactMessage contactMessage) {
        try {
            var result = new ContactMessage(
                    UUID.randomUUID(),
                    contactMessage.getSubject(),
                    contactMessage.getMessage(),
                    contactMessage.getName(),
                    contactMessage.getSurname(),
                    contactMessage.getPhone(),
                    contactMessage.getEmail()
            );
            contactMessageRepository.save(result);
            return "Successfully sent a new message!";
        } catch (Exception e) {
            return "Something went wrong";
        }
    }
}
