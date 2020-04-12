package mk.com.videosonik.store.service;

import mk.com.videosonik.store.model.Cart;
import mk.com.videosonik.store.model.CartHistory;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.model.semi_Models.ProductQuantity;

import java.util.List;

public interface CartService {

    //todo: Pageable
    List<CartHistory> getCartsByUserID(User user);

    void addProductToCart(Product product,User user, int quantity);

    void deleteProductFromCart(Product product, User user);

    void editQuantity(User user, Product product, int quantity);

    // closes last indexed cart, and puts it in history_cart
    void processCart(User user);

    List<Cart> getCurrentCarts(User user);

    List<ProductQuantity> getCurrentCartsPRQuantity(User user);

}
