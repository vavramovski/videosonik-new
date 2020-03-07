package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.CartHistory;
import mk.com.videosonik.store.model.User;

import java.util.List;

public interface CartHistoryRepository{
    List<CartHistory> getCartsByUser(User user);

    void saveCart(CartHistory cart);


    Integer findMaxIDbyUser(User user);

}
