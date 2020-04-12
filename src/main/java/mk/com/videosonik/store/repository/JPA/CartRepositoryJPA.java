package mk.com.videosonik.store.repository.JPA;

import mk.com.videosonik.store.model.Cart;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.model.semi_Models.ProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

//import mk.com.videosonik.store.model.CartCK;

public interface CartRepositoryJPA extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUsername(User user);

    Cart findCartByIdAndProductid(int id, Product product);

    Cart findCartByUsernameAndProductid(User user, Product product);

    @Query("select c from Cart c where c.username=?1 and c.productid=?2")
    Cart getmyCartByUserAndProduct(User user, Product product);


//    @Query("select c.productid, c.quantity from Cart c where c.username=?1")
    List<ProductQuantity> getAllByUsername(User user);

    @Transactional
    void deleteAllByUsername(User user);
}
