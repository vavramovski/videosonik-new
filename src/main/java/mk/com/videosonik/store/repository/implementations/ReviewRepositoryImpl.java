package mk.com.videosonik.store.repository.implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.Review;
import mk.com.videosonik.store.repository.JPA.ReviewRepositoryJPA;
import mk.com.videosonik.store.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {
    final ReviewRepositoryJPA reviewRepositoryJPA;

    @Override
    public void addReview(Review review) {
        reviewRepositoryJPA.save(review);
    }

    @Override
    public void removeReviewById(long id) {
        reviewRepositoryJPA.deleteById(id);
    }

    @Override
    public List<Review> getReviewsByProduct(Product product) {
        List<Review> reviews =reviewRepositoryJPA.findAllByProduct(product);
        return reviews;
    }
}
