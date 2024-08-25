package service;

import dao.ProjectDAO;
import dao.ProjectDAOImpl;
import model.Project;

import java.sql.SQLException;

public class ProjectService {
    private ProjectDAO projectDAO;

    public ProjectService() throws SQLException {
        this.projectDAO = new ProjectDAOImpl();
    }

    public boolean createProject(Project project) {
        projectDAO.saveProject(project);
        return true;
    }

    public Project getProjectById(String id) {
        return projectDAO.getProjectById(id);
    }

    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }
}
