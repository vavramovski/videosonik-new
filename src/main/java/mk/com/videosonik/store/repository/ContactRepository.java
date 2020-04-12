package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.ContactEMail;

import java.util.List;

public interface ContactRepository {

    void sendContact(ContactEMail contactEMail);

    void removeEmailById(Integer id);

    ContactEMail getContactById(Integer id);

    List<ContactEMail> getAllContacts();
}
