package mk.com.videosonik.store.repository.JPA;

import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

public interface ReviewRepositoryJPA extends JpaRepository<Review, Long> {

    @Query(value = "select r from Review r where r.product=?1")
    List<Review> findAllByProduct(Product product);
}
