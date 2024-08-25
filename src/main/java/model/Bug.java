package model;

import java.time.LocalDateTime;

public class Bug {
    private String bugId;
    private String title;
    private String description;
    private String severityLevel; // e.g., "Critical", "Major", "Minor"
    private LocalDateTime createdOn;
    private User createdBy; // The tester who created the bug
    private String status;   // e.g., "Open", "In Progress", "Resolved"
    private Project project; // The project the bug is associated with
    private String projectName;
    // Constructors
    public Bug() {}

    public Bug(String bugId, String title, String description, String severityLevel, LocalDateTime createdOn, User createdBy, String status, Project project) {
        this.bugId = bugId;
        this.title = title;
        this.description = description;
        this.severityLevel = severityLevel;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.status = status;
        this.project = project;
    }

    // Getters and Setters
    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    // Getter for projectName
    public String getProjectName() {
        return projectName;
    }
}
