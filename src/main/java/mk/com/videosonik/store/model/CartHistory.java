package mk.com.videosonik.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "cart_history")
@Entity(name = "CartHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CartCK.class)
public class CartHistory {

//    @EmbeddedId
//    private CartCK cartCK;

    @Id
    @JoinColumn(name = "id")
    private Integer id;

    @Id
    @JoinColumn(name = "username")
    @ManyToOne
    private User username;


    @Id
    @JoinColumn(name = "productid")
    @ManyToOne
    private Product productid;


    private int quantity;

    static public Cart transformToCart(CartHistory cart) {
        return new Cart(cart.getId(), cart.getUsername(), cart.getProductid(), cart.getQuantity());
    }
}