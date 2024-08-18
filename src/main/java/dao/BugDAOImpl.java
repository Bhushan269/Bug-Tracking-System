package dao;

import model.Bug;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BugDAOImpl implements BugDAO {
    private Connection connection;

    public BugDAOImpl() throws SQLException {
        connection = DBConnection.getConnection();
    }

    @Override
    public void saveBug(Bug bug) {
        String query = "INSERT INTO bugs (bugId, title, description, severityLevel, createdOn, createdBy, status, projectId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, bug.getBugId());
            ps.setString(2, bug.getTitle());
            ps.setString(3, bug.getDescription());
            ps.setString(4, bug.getSeverityLevel());
            ps.setObject(5, bug.getCreatedOn());
            ps.setString(6, bug.getCreatedBy().getUserId()); // Assuming createdBy is stored as userId
            ps.setString(7, bug.getStatus());
            ps.setString(8, bug.getProject().getProjectId()); // Assuming project is stored as projectId
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bug getBugById(String bugId) {
        String query = "SELECT * FROM bugs WHERE bugId = ?";
        Bug bug = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, bugId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bug = new Bug(
                        rs.getString("bugId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("severityLevel"),
                        rs.getObject("createdOn", LocalDateTime.class),
                        // Fetch the createdBy user object separately
                        null, // Placeholder for createdBy
                        rs.getString("status"),
                        // Fetch the project object separately
                        null  // Placeholder for project
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bug;
    }
    @Override
    public void updateBug(Bug bug) {
        String query = "UPDATE bugs SET title = ?, description = ?, severityLevel = ?, status = ? WHERE bugId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, bug.getTitle());
            ps.setString(2, bug.getDescription());
            ps.setString(3, bug.getSeverityLevel());
            ps.setString(4, bug.getStatus());
            ps.setString(5, bug.getBugId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBug(String bugId) {
        String query = "DELETE FROM bugs WHERE bugId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, bugId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}