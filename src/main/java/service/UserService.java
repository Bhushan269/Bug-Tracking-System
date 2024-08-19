package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.sql.SQLException;

public class UserService {

    private UserDAO userDAO;

    public UserService() throws SQLException {
        userDAO = new UserDAOImpl();
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
