package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepositoryJPA extends JpaRepository<User, String> {

    
}
