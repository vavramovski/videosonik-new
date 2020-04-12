package mk.com.videosonik.store.web;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.config.JwtTokenUtil;
import mk.com.videosonik.store.model.Admin;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.service.CartService;
import mk.com.videosonik.store.service.ProductService;
import mk.com.videosonik.store.service.UserService;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductsREST {

    final ProductService productService;
    final CartService cartService;
    final UserService userService;
    final JwtTokenUtil jwtTokenUtil;

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

//    @RolesAllowed(value = "ADMIN")
    //todo: roles
    @PatchMapping(path = "/{id}")
    public void editProduct(@PathVariable String id, @RequestBody Product newProduct,
                            @RequestHeader(name = "Authorization") String header) {
        String token = JwtTokenUtil.getTokenFromHeader(header);
        User user = userService.findUserByUsername(jwtTokenUtil.getUsernameFromToken(token));

//        String role = jwtTokenUtil.getRoleFromToken(header);
        if(user.getClass() == Admin.class)
            productService.editProduct(id, newProduct);
        else
            throw new AuthorizationServiceException("You're not ADMIN");
    }

    //todo: transfer this method in cart
    @PutMapping(path = "/cart/{productId}")
    public void addToCart(@PathVariable String productId, @RequestParam Integer quantity,
                          @RequestHeader(name = "Authorization") String header) {
        String token = JwtTokenUtil.getTokenFromHeader(header);

        String username = jwtTokenUtil.getUsernameFromToken(token);
        Product product = productService.getById(productId);
        User user = userService.findUserByUsername(username);
        cartService.addProductToCart(product, user, quantity);
    }


}
