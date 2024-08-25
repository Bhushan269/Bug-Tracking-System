package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        try {
            userService = new UserService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("registerUser".equals(action)) {
            String userId = request.getParameter("userId");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            User user = new User();
            user.setUserId(userId);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role);

            userService.saveUser(user);
            response.sendRedirect("login.jsp");
        } else if ("updateUser".equals(action)) {
            String userId = request.getParameter("userId");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = new User();
            user.setUserId(userId);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            userService.updateUser(user);
            response.sendRedirect("UserController?action=viewUser&userId=" + userId);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
