package mk.com.videosonik.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;

@Getter
@AllArgsConstructor
public class UserProductQuantity {
    Product product;
    User user;
    Integer quantity;
}
