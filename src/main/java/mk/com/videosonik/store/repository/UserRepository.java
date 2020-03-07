package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);

    User getUserById(String id);

    void deleteUser(User user);
    void deleteUserById(String id);

    void editUserById(String id, User user);

    void editUser(User oldUser, User newUser);

    List<User> getAllUsers();

}
