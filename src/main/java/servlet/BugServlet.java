package servlet;

import dao.BugDAO;
import dao.BugDAOImpl;
import model.Bug;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet("/reportBug")
public class BugServlet extends HttpServlet {
    private BugDAO bugDAO;

    @Override
    public void init() throws ServletException {
        try {
            bugDAO = new BugDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectName = request.getParameter("projectName");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String severityLevel = request.getParameter("severityLevel");
        User createdBy = ((User) request.getSession().getAttribute("user"));
        LocalDateTime createdOn = LocalDateTime.now();

        Bug bug = new Bug();
        bug.setProjectName(projectName);
        bug.setTitle(title);
        bug.setDescription(description);
        bug.setSeverityLevel(severityLevel);
        bug.setCreatedBy(createdBy);
        bug.setCreatedOn(createdOn);

        bugDAO.saveBug(bug);

        response.sendRedirect("bugList.jsp");
    }
}
