package mk.com.videosonik.store.repository.JPA;

import mk.com.videosonik.store.model.ContactEMail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepositoryJPA extends JpaRepository<ContactEMail,Integer> {
}
