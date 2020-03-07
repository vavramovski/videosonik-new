package mk.com.videosonik.store.repository.implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.CartHistory;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.repository.CartHistoryRepository;
import mk.com.videosonik.store.repository.JPA.CartHistoryRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CartHistoryRepositoryImpl implements CartHistoryRepository {
    final CartHistoryRepositoryJPA cartHistoryRepositoryJPA;

    @Override
    public List<CartHistory> getCartsByUser(User user) {
        return cartHistoryRepositoryJPA.findAllByUsername(user);
    }

    @Override
    public void saveCart(CartHistory cart) {
        cartHistoryRepositoryJPA.save(cart);
    }

    @Override
    public Integer findMaxIDbyUser(User user) {
        Integer maxid = cartHistoryRepositoryJPA.fetchMaxIdByUsername(user);
        if (maxid == null) return -1;
        else
            return maxid;
    }
}
