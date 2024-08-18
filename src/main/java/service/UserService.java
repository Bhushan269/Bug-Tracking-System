package service;

import dao.UserDAO;
import model.User;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User getUserById(String userId) {
        return userDAO.getUserById(userId);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
}
