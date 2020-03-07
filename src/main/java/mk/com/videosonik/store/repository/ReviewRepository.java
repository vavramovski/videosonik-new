package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.Review;

import java.util.List;

public interface ReviewRepository {

    void addReview(Review review);

    void removeReviewById(long id);

    List<Review> getReviewsByProduct(Product product);


}
