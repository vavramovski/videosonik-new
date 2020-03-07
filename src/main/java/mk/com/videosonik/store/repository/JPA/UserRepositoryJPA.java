package mk.com.videosonik.store.repository.JPA;

import mk.com.videosonik.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepositoryJPA extends JpaRepository<User, String> {

    
}
