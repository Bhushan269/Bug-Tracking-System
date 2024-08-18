package model;

import java.util.List;

public class Project {
    private String projectId;
    private String projectName;
    private String startDate; // You may choose a different type like LocalDate if preferred
    private String status;    // e.g., "In Progress", "Completed"
    private User projectManager;
    private List<User> teamMembers; // Team members including Developers and Testers

    // Constructors
    public Project() {}

    public Project(String projectId, String projectName, String startDate, String status, User projectManager, List<User> teamMembers) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.status = status;
        this.projectManager = projectManager;
        this.teamMembers = teamMembers;
    }

    // Getters and Setters
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<User> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
