package mk.com.videosonik.store.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
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


}