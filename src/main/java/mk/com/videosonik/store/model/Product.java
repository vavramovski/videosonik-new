package mk.com.videosonik.store.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    private String productid;

    private int price;

    @Column(columnDefinition="TEXT")
    private String image;

    private String description;

    private String keywords;

    private int countininventory;

    private String category;

    public void setNewValues(Product newProduct) {
        setPrice(newProduct.getPrice());
        setImage(newProduct.getImage());
        setDescription(newProduct.getDescription());
        setKeywords(newProduct.getKeywords());
        setCountininventory(newProduct.getCountininventory());
        setCategory(newProduct.getCategory());
    }
}
