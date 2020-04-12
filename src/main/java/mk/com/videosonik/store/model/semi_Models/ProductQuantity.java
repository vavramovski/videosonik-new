package mk.com.videosonik.store.model.semi_Models;

import mk.com.videosonik.store.model.Cart;
import mk.com.videosonik.store.model.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "productQuantity",
        types = Cart.class)
public interface ProductQuantity {

    Product getProductid();

    Integer getQuantity();
}
