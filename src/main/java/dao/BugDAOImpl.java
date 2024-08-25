package dao;

import model.Bug;
import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Bug> getAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM bugs";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Bug bug = new Bug();
                bug.setBugId(resultSet.getString("id"));
                bug.setProjectName(resultSet.getString("projectName"));
                bug.setTitle(resultSet.getString("title"));
                bug.setDescription(resultSet.getString("description"));
                bug.setSeverityLevel(resultSet.getString("severity"));
                bug.setCreatedBy((User) resultSet.getObject("createdBy"));
                bug.setCreatedOn(resultSet.getTimestamp("createdOn").toLocalDateTime());
                bugs.add(bug);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bugs;
    }
}