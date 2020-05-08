package mk.com.videosonik.store.service.Implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.repository.ProductRepository;
import mk.com.videosonik.store.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceIMPL  implements ProductService {

    final ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void editProduct(String id, Product newProduct) {
        productRepository.editProduct(id,newProduct);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.deleteProduct(product);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public List<Product> getAllProduct() {
       return productRepository.getAllProduct();
    }

    @Override
    public Product getById(String id) {
        return productRepository.getById(id);
    }

    @Override //TODO: parametri za page.size , page number
    public Page<Product> getPagedProducts(Pageable pageable) {
        return productRepository.getPagedProducts(pageable);
    }
}
