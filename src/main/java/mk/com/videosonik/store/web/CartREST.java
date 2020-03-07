package mk.com.videosonik.store.web;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.UserProductQuantity;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cart")
@AllArgsConstructor
public class CartREST {

    final CartService cartService;

    @PostMapping(path = "/process")
    public void processCart(@RequestBody User user) {
        cartService.processCart(user);
    }

    @PostMapping(path = "/editQuantity")
    public void editQuantity(@RequestBody UserProductQuantity userProductQuantity) {
        cartService.editQuantity(userProductQuantity.getUser(), userProductQuantity.getProduct(), userProductQuantity.getQuantity());
    }
}
