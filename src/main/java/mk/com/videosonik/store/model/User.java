package mk.com.videosonik.store.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String username;

    private String email;

    private String password;


    @Column(name = "product")
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product>wishlist;


}