package mk.com.videosonik.store.service.Implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Cart;
import mk.com.videosonik.store.model.CartHistory;
import mk.com.videosonik.store.model.Exceptions.ExceededCountInInventory;
import mk.com.videosonik.store.model.Exceptions.NotFound;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.model.semi_Models.ProductQuantity;
import mk.com.videosonik.store.repository.CartHistoryRepository;
import mk.com.videosonik.store.repository.CartRepository;
import mk.com.videosonik.store.repository.ProductRepository;
import mk.com.videosonik.store.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceIMPL implements CartService {
    final CartHistoryRepository historyRepository;
    final CartRepository cartRepository;
    final ProductRepository productRepository;

    @Override
    public List<CartHistory> getCartsByUserID(User user) {
        return historyRepository.getCartsByUser(user);
    }

    @Override
    public void addProductToCart(Product product, User user, int quantity) {
        cartRepository.addProductToCart(product, user, quantity);
    }

    @Override
    public void deleteProductFromCart(Product product, User user) {
        cartRepository.deleteProductFromCart(product, user);
    }

    @Override
    public void editQuantity(User user, Product product, int quantity) {
        cartRepository.editQuantity(user, product, quantity);
    }

    @Override
    public void processCart(User user) {
        try {
            ArrayList<Cart> cartList = (ArrayList<Cart>) cartRepository.getCartsByUserID(user);
            Integer id = historyRepository.findMaxIDbyUser(user);
            if (id != -1) {
                for (Cart c : cartList) {
                    Product product = c.getProductid();
                    int productsInInventory = product.getCountininventory();
                    if (c.getQuantity() <= productsInInventory) {
                        product.setCountininventory(productsInInventory - c.getQuantity());
                        productRepository.editProduct(product.getProductid(), product);
                    } else {
                        throw new ExceededCountInInventory(productsInInventory + "");
                    }
                    historyRepository.saveCart(new CartHistory(id + 1, c.getUsername(), c.getProductid(), c.getQuantity()));
                }
            } else {
                for (Cart c : cartList) {
                    Product product = c.getProductid();
                    int productsInInventory = product.getCountininventory();
                    if (c.getQuantity() <= productsInInventory) {
                        product.setCountininventory(productsInInventory - c.getQuantity());
                        productRepository.editProduct(product.getProductid(), product);
                    } else {
                        throw new ExceededCountInInventory(productsInInventory + "");
                    }
                    historyRepository.saveCart(new CartHistory(0, c.getUsername(), c.getProductid(), c.getQuantity()));
                }
            }
            cartRepository.deleteCartsUser(user);
        } catch (Exception e) {
            throw new NotFound();
        }
    }

    @Override
    public List<Cart> getCurrentCarts(User user) {
        return cartRepository.getCartsByUserID(user);
    }

    @Override
    public List<ProductQuantity> getCurrentCartsPRQuantity(User user) {
        return cartRepository.getCurrentCartsPRQuantity(user);
    }
}
