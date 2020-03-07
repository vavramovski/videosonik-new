package mk.com.videosonik.store.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCK implements Serializable {


    //TODO: imenuvaj gi kolonite
//    @JoinColumn(name = "username")
    private String username;

//    @JoinColumn(name = "productid")
    private String productid;

//    @Column(name = "id")
    public Integer id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartCK cartCK = (CartCK) o;
        return id == cartCK.id &&
                Objects.equals(username, cartCK.username) &&
                Objects.equals(productid, cartCK.productid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, productid, id);
    }

}
