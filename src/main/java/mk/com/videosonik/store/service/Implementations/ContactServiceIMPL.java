package mk.com.videosonik.store.service.Implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.ContactEMail;
import mk.com.videosonik.store.repository.ContactRepository;
import mk.com.videosonik.store.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceIMPL implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public void sendContact(ContactEMail contactEMail) {
        contactRepository.sendContact(contactEMail);
    }

    @Override
    public void removeEmailById(Integer id) {
        contactRepository.removeEmailById(id);
    }

    @Override
    public List<ContactEMail> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    @Override
    public ContactEMail getContactById(Integer id) {
        return contactRepository.getContactById(id);
    }
}
