package mk.com.videosonik.store.service;

import mk.com.videosonik.store.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    void editProduct(String id,Product product);

    void deleteProduct(Product product);
    void deleteProductById(String id);

    List<Product> getAllProduct();

    Product getById(String id);

    Page<Product> getPagedProducts();

}
