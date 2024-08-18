package dao;

import model.Project;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDAOImpl implements ProjectDAO {
    private Connection connection;

    public ProjectDAOImpl() throws SQLException {
        connection = DBConnection.getConnection();
    }

    @Override
    public void saveProject(Project project) {
        String query = "INSERT INTO projects (projectId, projectName, startDate, status, managerId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, project.getProjectId());
            ps.setString(2, project.getProjectName());
            ps.setString(3, project.getStartDate());
            ps.setString(4, project.getStatus());
            ps.setString(5, project.getProjectManager().getUserId()); // Assuming project manager is stored as userId
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getProjectById(String projectId) {
        String query = "SELECT * FROM projects WHERE projectId = ?";
        Project project = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Here you might need to fetch team members separately
                project = new Project(
                        rs.getString("projectId"),
                        rs.getString("projectName"),
                        rs.getString("startDate"),
                        rs.getString("status"),
                        // Fetch the project manager object separately
                        null, // Placeholder for projectManager
                        null  // Placeholder for teamMembers
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void updateProject(Project project) {
        String query = "UPDATE projects SET projectName = ?, startDate = ?, status = ? WHERE projectId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, project.getProjectName());
            ps.setString(2, project.getStartDate());
            ps.setString(3, project.getStatus());
            ps.setString(4, project.getProjectId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(String projectId) {
        String query = "DELETE FROM projects WHERE projectId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, projectId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
