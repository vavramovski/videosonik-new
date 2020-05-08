package mk.com.videosonik.store.repository.implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Exceptions.NotFound;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.repository.JPA.ProductRepositoryJPA;
import mk.com.videosonik.store.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor

public class ProductRepositoryImpl implements ProductRepository {
    final ProductRepositoryJPA productRepositoryJPA;

    @Override
    public void addProduct(Product product) {
        productRepositoryJPA.save(product);
    }

    @Override // ne raboti ako probuvas da smenis ID
    public void editProduct(String id, Product newProduct) {
        Product product = productRepositoryJPA.findById(id).orElseThrow(NotFound::new);
        product.setNewValues(newProduct);
        productRepositoryJPA.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepositoryJPA.delete(product);
    }

    @Override
    public void deleteProductById(String id) {
        productRepositoryJPA.deleteById(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepositoryJPA.findAll();
    }

    @Override
    public Product getById(String id) {
        return productRepositoryJPA.findById(id).orElseThrow(NotFound::new);
    }

    //TODO: getPagedProducts
    @Override
    public Page<Product> getPagedProducts(Pageable pageable) {
        return productRepositoryJPA.findAll(pageable);
    }
}
