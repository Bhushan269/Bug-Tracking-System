package service;

import dao.ProjectDAO;
import dao.ProjectDAOImpl;
import model.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    private ProjectDAO projectDAO;

    public ProjectService() throws SQLException {
        this.projectDAO = new ProjectDAOImpl();
    }

    public void createProject(Project project) {
        projectDAO.saveProject(project);
    }

    public Project getProjectById(String id) {
        return projectDAO.getProjectById(id);
    }

    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }
}
