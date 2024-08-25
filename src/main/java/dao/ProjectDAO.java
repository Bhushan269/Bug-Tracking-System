package dao;

import model.Project;

public interface ProjectDAO {
    void saveProject(Project project);
    Project getProjectById(String projectId);
    void updateProject(Project project);
    void deleteProject(String projectId);
}
