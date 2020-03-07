package mk.com.videosonik.store.repository.JPA;

import mk.com.videosonik.store.model.CartHistory;
import mk.com.videosonik.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//import mk.com.videosonik.store.model.CartCK;

public interface CartHistoryRepositoryJPA extends JpaRepository<CartHistory, Long> {

    List<CartHistory> findAllByUsername(User user);

//    CartHistory findCartByIdAndProductid(int id, Product product);

    @Query("select max(c.id)from CartHistory c where c.username=?1")
    Integer fetchMaxIdByUsername(User user);

}
