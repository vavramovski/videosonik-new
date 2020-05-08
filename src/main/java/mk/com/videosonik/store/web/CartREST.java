package mk.com.videosonik.store.web;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.config.JwtTokenUtil;
import mk.com.videosonik.store.model.CartHistory;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.model.semi_Models.ProductQuantity;
import mk.com.videosonik.store.service.CartService;
import mk.com.videosonik.store.service.ProductService;
import mk.com.videosonik.store.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/cart")
@AllArgsConstructor
public class CartREST {

    final CartService cartService;
    final UserService userService;
    final ProductService productService;
    final JwtTokenUtil jwtTokenUtil;

    @GetMapping(path = "/process")
    public void processCart(@RequestHeader(name = "Authorization") String header) {
        String token = JwtTokenUtil.getTokenFromHeader(header);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        User user = userService.findUserByUsername(username);
        cartService.processCart(user);
    }

    @PostMapping(path = "/editQuantity/{productid}")
    public void editQuantity(@PathVariable String productid, @RequestParam Integer quantity,
                             @RequestHeader(name = "Authorization") String header) {
        String token = JwtTokenUtil.getTokenFromHeader(header);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        User user = userService.findUserByUsername(username);
        Product product = productService.getById(productid);
        cartService.editQuantity(user, product,quantity);
    }

    @GetMapping("/history")
    public List<CartHistory> getHistoryCarts(@RequestHeader(name = "Authorization") String header) {
        String token = JwtTokenUtil.getTokenFromHeader(header);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        User user = userService.findUserByUsername(username);
        return cartService.getCartsByUserID(user);
    }

    @GetMapping
    public List<ProductQuantity> getCurrentCarts(@RequestHeader(name = "Authorization") String header) {
        String token = JwtTokenUtil.getTokenFromHeader(header);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        User user = userService.findUserByUsername(username);
        List<ProductQuantity> asd = cartService.getCurrentCartsPRQuantity(user);
        for (ProductQuantity prq : asd) {
            System.out.println(prq.getProductid() + "   " + prq.getQuantity());
        }
        return asd;
    }
}
