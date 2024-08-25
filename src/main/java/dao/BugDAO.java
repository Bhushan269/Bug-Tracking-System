package dao;

import model.Bug;

import java.util.List;

public interface BugDAO {
    void saveBug(Bug bug);
    Bug getBugById(String bugId);
    void updateBug(Bug bug);
    void deleteBug(String bugId);
    List<Bug> getAllBugs();
}
