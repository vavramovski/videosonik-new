package mk.com.videosonik.store.repository.JPA;

import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

public interface ReviewRepositoryJPA extends JpaRepository<Review, Long> {

    List<Review> findAllByProduct(Product product);
}
