package mk.com.videosonik.store.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.security.DeclareRoles;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
@DeclareRoles("CUSTOMER")
public class User implements Serializable {

    @Id
    private String username;

    private String email;

    private String password;

    @JoinTable(name = "wishlist",
            joinColumns = {@JoinColumn(name = "username")},
     inverseJoinColumns = {@JoinColumn(name = "productid")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> wishlist;


    public void addToWishlist(Product product){
        if(!wishlist.contains(product))
            wishlist.add(product);
    }

    public void removeFromWishlist(Product product) {
        wishlist.remove(product);
    }

}