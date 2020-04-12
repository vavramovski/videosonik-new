package mk.com.videosonik.store.service;


import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;

public interface WishlistService {
    void addToWishlist(String user, String productId);

    void removeFromWishlist(String user, String productId);
}
