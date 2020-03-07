package mk.com.videosonik.store.repository.implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Cart;
import mk.com.videosonik.store.model.Exceptions.NotFound;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.repository.CartRepository;
import mk.com.videosonik.store.repository.JPA.CartHistoryRepositoryJPA;
import mk.com.videosonik.store.repository.JPA.CartRepositoryJPA;
import mk.com.videosonik.store.repository.JPA.UserRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@AllArgsConstructor
public class CartRepositoryImpl implements CartRepository {
    final CartRepositoryJPA cartRepositoryJPA;
    final UserRepositoryJPA userRepositoryJPA;
    final CartHistoryRepositoryJPA historyCartRepositoryJPA;


    @Override
    public List<Cart> getCartsByUserID(User user) {
        return cartRepositoryJPA.findAllByUsername(user);
    }

    @Override
    public void addProductToCart(Product product, User user, int quantity) {
        List<Cart> carts = getCartsByUserID(user);
        carts.sort(Comparator.comparing(Cart::getId).reversed());

        if (carts.size()>0){
            Cart newCart = new Cart(carts.get(0).getId(), user, product, quantity);
            cartRepositoryJPA.save(newCart);
        }
        else {
            // postgres trigger - na id = 0, go setira id na id = max(id za userot) +1
            Cart triggerCart = new Cart(1, user, product, quantity);
            cartRepositoryJPA.save(triggerCart);
        }
    }

    @Override
    public void editQuantity(User user, Product product, int quantity) {
        try {
            Cart cart = cartRepositoryJPA.getmyCartByUserAndProduct(user, product);
            cart.setQuantity(quantity);
            cartRepositoryJPA.save(cart);
        }
        catch (Exception e){
            throw new NotFound();
        }
    }


    @Override
    public void deleteProductFromCart(Product product, User user) {
        List<Cart> carts = getCartsByUserID(user);
        carts.sort(Comparator.comparing(Cart::getId).reversed());

        int highestId =carts.get(0).getId();
        Cart deletedToBe = cartRepositoryJPA.findCartByIdAndProductid(highestId, product);
        cartRepositoryJPA.delete(deletedToBe);
    }

    @Override
    public void deleteCartsUser(User user) {
        cartRepositoryJPA.deleteAllByUsername(user);
    }
}
