package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositoryJPA extends JpaRepository<Review, Long> {
}
