package mk.com.videosonik.store.web;


import lombok.AllArgsConstructor;
import mk.com.videosonik.store.config.JwtTokenUtil;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.service.ProductService;
import mk.com.videosonik.store.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/wishlist")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class WishListREST {
    final ProductService productService;
    final UserService userService;
    final JwtTokenUtil jwtTokenUtil;

    @PostMapping(path = "/add/{productid}")
    public void addProductToWishList(@RequestHeader(name = "Authorization") String token,
                                     @PathVariable("productid") String productid) {
        String tokenFromHeader = JwtTokenUtil.getTokenFromHeader(token);
        String username = jwtTokenUtil.getUsernameFromToken(tokenFromHeader);
        User user = userService.findUserByUsername(username);
        Product product = productService.getById(productid);
        user.addToWishlist(product);
        userService.addUser(user);
    }

    @PostMapping(path = "/remove/{productid}")
    public void removeProductFromWishList(@RequestHeader(name = "Authorization") String token,
                                          @PathVariable("productid") String productid) {
        String tokenFromHeader = JwtTokenUtil.getTokenFromHeader(token);
        String username = jwtTokenUtil.getUsernameFromToken(tokenFromHeader);
        User user = userService.findUserByUsername(username);
        Product product = productService.getById(productid);
        user.removeFromWishlist(product);
        userService.addUser(user);
    }

    @GetMapping()
    public List<Product> getWishlist(@RequestHeader(name = "Authorization") String header) {
        String tokenFromHeader = JwtTokenUtil.getTokenFromHeader(header);
        String username = jwtTokenUtil.getUsernameFromToken(tokenFromHeader);
        User user = userService.findUserByUsername(username);

        return user.getWishlist();
    }


}
