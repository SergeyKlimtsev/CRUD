package crud.service;


import crud.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateuser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> getAllUsersList();

    List<User> searchUsersByName(String name);

}
