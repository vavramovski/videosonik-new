package mk.com.videosonik.store.web;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.config.JwtTokenUtil;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.Review;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.service.ReviewService;
import mk.com.videosonik.store.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/review")
@AllArgsConstructor
public class ReviewREST {
    private final ReviewService reviewService;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    @PostMapping
    public void addReview(@RequestHeader(name = "Authorization") String header, @RequestBody Review review) {
        String token = JwtTokenUtil.getTokenFromHeader(header);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = userService.findUserByUsername(username);
        review.setUser(user);
        reviewService.addReview(review);
    }

    @DeleteMapping
    public void removeReviewById(long id) {
        reviewService.removeReviewById(id);
    }

    @GetMapping
    public List<Review> getReviewsByProduct(@RequestParam String productId) {
        return reviewService.getReviewsByProduct(productId);
    }
}
