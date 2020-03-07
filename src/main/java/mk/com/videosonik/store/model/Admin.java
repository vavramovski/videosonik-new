package mk.com.videosonik.store.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "admins")
@Entity(name = "Admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User implements Serializable {

    public Admin(User user, Privileges privileges) {
        super(user.getUsername(), user.getEmail(), user.getPassword(), user.getWishlist());
        this.privileges = privileges;
    }

    @Enumerated(EnumType.STRING)
    @JoinTable(name = "privileges")
    private Privileges privileges;

}
