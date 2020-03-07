package mk.com.videosonik.store.repository.implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Exceptions.NotFound;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.repository.JPA.UserRepositoryJPA;
import mk.com.videosonik.store.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    final UserRepositoryJPA userRepositoryJPA;


    @Override
    public void addUser(User user) {
        userRepositoryJPA.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepositoryJPA.findById(id).orElseThrow(NotFound::new);
    }

    @Override
    public void deleteUser(User user) {
        userRepositoryJPA.delete(user);
    }

    @Override
    public void deleteUserById(String id) {
        userRepositoryJPA.deleteById(id);
    }

    @Override
    public void editUserById(String id, User user) {
        userRepositoryJPA.deleteById(id);
        userRepositoryJPA.save(user);
    }

    @Override
    public void editUser(User oldUser, User newUser) {
        userRepositoryJPA.delete(oldUser);
        userRepositoryJPA.save(newUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryJPA.findAll();
    }
}
