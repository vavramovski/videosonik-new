package mk.com.videosonik.store.repository.JPA;

import mk.com.videosonik.store.model.Admin;
import mk.com.videosonik.store.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositoryJPA extends JpaRepository<Admin,String > {
}
