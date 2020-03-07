package mk.com.videosonik.store.service;

import mk.com.videosonik.store.model.User;

public interface UserRepository {
    void addUser(User user);

    User findUserByUsername(String username);

    void deleteUserById(String username);
    void deleteUser(User user);


}
