package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);
    void editProduct(String id,Product product);


    void deleteProduct(Product product);
    void deleteProductById(String id);

    List<Product> getAllProduct();

    Product getById(String id);

    Page<Product> getPagedProducts(Pageable pageable);

    //todo: get by category
}
