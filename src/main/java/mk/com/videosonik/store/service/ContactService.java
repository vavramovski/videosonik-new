package mk.com.videosonik.store.service;

import mk.com.videosonik.store.model.ContactEMail;

import java.util.List;

public interface ContactService {

     void sendContact(ContactEMail contactEMail);

     void removeEmailById(Integer id);

     List<ContactEMail> getAllContacts();

     ContactEMail getContactById(Integer id);
}
