package mk.com.videosonik.store.web;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductsREST {

    final ProductService productService;

    @GetMapping //TODO: PAGEABLE namesto LIST
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping(path = "/{id}")
    public Product getOneProduct(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping(path = "/new")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PatchMapping(path = "/{id}")
    public void editProduct(@PathVariable String id, @RequestBody Product newProduct) {
        productService.editProduct(id, newProduct);
    }


}
