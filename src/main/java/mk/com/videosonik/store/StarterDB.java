package mk.com.videosonik.store;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.*;
import mk.com.videosonik.store.repository.JPA.*;
import mk.com.videosonik.store.service.CartService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class StarterDB {

    List<Review> reviewList;
    List<Cart>cartList;
    List<User>userList;
    List<Product>productList;

    private final CartRepositoryJPA cartRepositoryJPA;
    private final ProductRepositoryJPA productRepositoryJPA;
    private final ReviewRepositoryJPA reviewRepositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;
    private final AdminRepositoryJPA adminRepositoryJPA;

    private final CartService cartService;

    @PostConstruct
    public void init() {
        userList = new LinkedList<>();
        productList = new LinkedList<>();
        cartList = new LinkedList<>();
        reviewList = new LinkedList<>();
        User user = new User("testest", "emailot", "paswrd", new LinkedList<>());
//        Product product = new Product("123", 200, "img", "descrptioasdo", "keywrds", 5,"LED");

//        userList.add(user);
//        productList.add(product);


//        cartList.add(new Cart(11, user, product, 25));
//        reviewList.add(new Review(2, user, product, "komentar", 2, ));

       /* userList = userRepositoryJPA.findAll();
        productList= productRepositoryJPA.findAll();
        for (User u :userList) {
            for (Product p :productList) {
                cartService.addProductToCart(p,u,5);
            }
        }*/

//        if(!userRepositoryJPA.findById(user.getUsername()).isPresent()){
//            userRepositoryJPA.save(user);
//        }
//            User piki = userRepositoryJPA.findById("test1").get();

            Admin admin = new Admin(user, Privileges.admin);
            adminRepositoryJPA.save(admin);

//        productRepositoryJPA.save(product);
//        cartRepositoryJPA.save(cartList.get(0));
//        reviewRepositoryJPA.save(reviewList.get(0));


//        Admin pikiadmin = adminRepositoryJPA.findById("Likson").get();
//        pikiadmin.setPrivileges(Privileges.sales);
//        adminRepositoryJPA.save(pikiadmin);

    }
}
