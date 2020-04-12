package mk.com.videosonik.store.service.Implementations;

import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.repository.ProductRepository;
import mk.com.videosonik.store.repository.UserRepository;
import mk.com.videosonik.store.service.WishlistService;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceIMPL implements WishlistService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WishlistServiceIMPL(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addToWishlist(String username, String product) {
        User user = userRepository.getUserById(username);
        Product product1 = productRepository.getById(product);

        user.addToWishlist(product1);
    }

    @Override
    public void removeFromWishlist(String username, String product) {
        User user = userRepository.getUserById(username);
        Product product1 = productRepository.getById(product);

        user.removeFromWishlist(product1);
    }
}
