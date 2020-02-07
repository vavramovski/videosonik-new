package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.Cart;
import mk.com.videosonik.store.model.UserProductCK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepositoryJPA extends JpaRepository<Cart, Long> {
}
