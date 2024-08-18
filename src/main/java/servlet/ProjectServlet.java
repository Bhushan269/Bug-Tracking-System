package servlet;

import dao.ProjectDAO;
import dao.ProjectDAOImpl;
import model.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/createProject")
public class ProjectServlet extends HttpServlet {
    private ProjectDAO projectDAO;

    @Override
    public void init() throws ServletException {
        try {
            projectDAO = new ProjectDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectName = request.getParameter("projectName");
        String startDate = Date.valueOf(request.getParameter("startDate")).toString();

        Project project = new Project();
        project.setProjectName(projectName);
        project.setStartDate(startDate);

        projectDAO.saveProject(project);

        response.sendRedirect("projectList.jsp");
    }
}
