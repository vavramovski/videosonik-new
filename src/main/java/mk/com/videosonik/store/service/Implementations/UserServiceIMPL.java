package mk.com.videosonik.store.service.Implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.repository.UserRepository;
import mk.com.videosonik.store.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceIMPL implements UserService {
    final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.getUserById(username);
    }

    @Override
    public void deleteUserById(String username) {
        userRepository.deleteUserById(username);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }



}
