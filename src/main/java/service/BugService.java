
package service;

import dao.BugDAO;
import dao.BugDAOImpl;
import model.Bug;

import java.sql.SQLException;
import java.util.List;

public class BugService {
    private BugDAO bugDAO;

    public BugService() throws SQLException {
        this.bugDAO = new BugDAOImpl();  // Using the implementation class
    }

    public void reportBug(Bug bug) {
        bugDAO.saveBug(bug);
    }

    public List<Bug> getAllBugs() {
        return bugDAO.getAllBugs();
    }

    public Bug getBugById(String id) {
        return bugDAO.getBugById(id);
    }

    public void updateBug(Bug bug) {
        bugDAO.updateBug(bug);
    }
}
