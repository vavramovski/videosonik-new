package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<Product,String> {
}
