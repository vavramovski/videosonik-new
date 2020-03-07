package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.Cart;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;

import java.util.List;

public interface CartRepository {
    List<Cart> getCartsByUserID(User user);

    void addProductToCart(Product product,User user, int quantity);

    void deleteProductFromCart(Product product, User user);

    void editQuantity(User user, Product product, int quantity);

    void deleteCartsUser(User user);

}
