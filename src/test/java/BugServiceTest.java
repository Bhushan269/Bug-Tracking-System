
import dao.BugDAO;
import model.Bug;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.BugService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BugServiceTest {

    @Mock
    private BugDAO bugDAO;

    @InjectMocks
    private BugService bugService;

    private Bug bug;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bug = new Bug();
        bug.setBugId(String.valueOf(1));
        bug.setTitle("Sample Bug");
        bug.setDescription("This is a sample bug");
        bug.setSeverityLevel("High");
        bug.setCreatedBy("tester1");
        bug.setCreatedOn(LocalDateTime.now());
    }

    @Test
    void testReportBug() {
        when(bugDAO.saveBug(any(Bug.class))).thenReturn(true);

        boolean result = bugService.reportBug(bug);

        assertTrue(result);
        verify(bugDAO, times(1)).saveBug(any(Bug.class));
    }

    @Test
    void testGetAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        bugs.add(bug);

        when(bugDAO.getAllBugs()).thenReturn(bugs);

        List<Bug> result = bugService.getAllBugs();

        assertEquals(1, result.size());
        assertEquals("Sample Bug", result.get(0).getTitle());
    }
}
