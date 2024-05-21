package travelAgency.agency.application;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import travelAgency.agency.domain.ContactMessage;
import travelAgency.agency.domain.ContactMessageRepository;

import java.util.List;

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
    public ContactMessage createMessage(ContactMessage contactMessage) {
        return contactMessageRepository.save(contactMessage);
    }
}
