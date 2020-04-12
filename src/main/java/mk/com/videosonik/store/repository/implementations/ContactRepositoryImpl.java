package mk.com.videosonik.store.repository.implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.ContactEMail;
import mk.com.videosonik.store.model.Exceptions.NotFound;
import mk.com.videosonik.store.repository.ContactRepository;
import mk.com.videosonik.store.repository.JPA.ContactRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ContactRepositoryImpl implements ContactRepository {

    private final ContactRepositoryJPA contactRepositoryJPA;

    @Override
    public void sendContact(ContactEMail contactEMail) {
            contactRepositoryJPA.save(contactEMail);
    }

    @Override
    public void removeEmailById(Integer id) {
            contactRepositoryJPA.deleteById(id);
    }

    @Override
    public List<ContactEMail> getAllContacts() {
        return contactRepositoryJPA.findAll();
    }

    @Override
    public ContactEMail getContactById(Integer id) {
        return contactRepositoryJPA.findById(id).orElseThrow(NotFound::new);
    }
}
