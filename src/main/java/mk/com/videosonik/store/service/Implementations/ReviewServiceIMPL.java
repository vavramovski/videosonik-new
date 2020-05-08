package mk.com.videosonik.store.service.Implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.Review;
import mk.com.videosonik.store.repository.ReviewRepository;
import mk.com.videosonik.store.repository.implementations.ReviewRepositoryImpl;
import mk.com.videosonik.store.service.ProductService;
import mk.com.videosonik.store.service.ReviewService;
import mk.com.videosonik.store.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceIMPL implements ReviewService {
    private final ProductService productService;
    private final UserService userService;
    private final ReviewRepository reviewRepository;

    @Override
    public void addReview(Review review) {
        reviewRepository.addReview(review);
    }

    @Override
    public void removeReviewById(long id) {
        reviewRepository.removeReviewById(id);
    }

    @Override
    public List<Review> getReviewsByProduct(String productId) {
        Product product = productService.getById(productId);
        return reviewRepository.getReviewsByProduct(product);
    }
}
