package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() throws SQLException {
        this.userDAO = new UserDAOImpl();
    }

    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    public User loginUser(String email, String password) {
        User user = userDAO.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User getUserById(String id) {
        return userDAO.getUserById(id);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
