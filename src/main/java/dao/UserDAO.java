package dao;

import model.User;

public interface UserDAO {
    void saveUser(User user);
    User getUserById(String userId);
    User getUserByEmail(String email);
    void updateUser(User user);
    void deleteUser(String userId);
}
