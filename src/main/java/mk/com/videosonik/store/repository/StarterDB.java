package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.Cart;
import mk.com.videosonik.store.model.Product;
import mk.com.videosonik.store.model.Review;
import mk.com.videosonik.store.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class StarterDB {

    List<Review> reviewList;
    List<Cart>cartList;
    List<User>userList;
    List<Product>productList;

    private final CartRepositoryJPA cartRepositoryJPA;
    private final ProductRepositoryJPA productRepositoryJPA;
    private final ReviewRepositoryJPA reviewRepositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;

    public StarterDB(CartRepositoryJPA cartRepositoryJPA, ProductRepositoryJPA productRepositoryJPA, ReviewRepositoryJPA reviewRepositoryJPA, UserRepositoryJPA userRepositoryJPA) {
        this.cartRepositoryJPA = cartRepositoryJPA;
        this.productRepositoryJPA = productRepositoryJPA;
        this.reviewRepositoryJPA = reviewRepositoryJPA;
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @PostConstruct
    public void init() {
        userList = new LinkedList<>();
        productList = new LinkedList<>();
        cartList = new LinkedList<>();
        reviewList = new LinkedList<>();
        User user = new User("Likikalkulus", "emailot", "paswrd", new LinkedList<>());
        Product product = new Product("123", 200, "img", "descrptioasdo", "keywrds", 5);

        userList.add(user);
        productList.add(product);
        cartList.add(new Cart(1, user, product, 25));
        reviewList.add(new Review(1, user, product, "komentar", 2));


        userRepositoryJPA.save(user);
        productRepositoryJPA.save(product);
        cartRepositoryJPA.save(cartList.get(0));
        reviewRepositoryJPA.save(reviewList.get(0));

//        user.setWishlist(productList);

        userRepositoryJPA.findById("Likikalkulus").ifPresent(x-> x.setWishlist(productList));

    }
}
