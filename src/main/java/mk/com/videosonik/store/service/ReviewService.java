package mk.com.videosonik.store.service;

import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.Review;

import java.util.List;

public interface ReviewService {
    void addReview(Review review);

    void removeReviewById(long id);

    //todo: pageable
    List<Review> getReviewsByProduct(String productId);
}
