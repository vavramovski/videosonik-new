package mk.com.videosonik.store.service;

import mk.com.videosonik.store.model.User;

public interface UserService {
    void addUser(User user);

    User findUserByUsername(String username);
    //todo tokenov sredi
//    User findUserByUsernameAndTOKEN(String username,String token);
    void deleteUserById(String username);
    void deleteUser(User user);


}
