
import dao.ProjectDAO;
import model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.ProjectService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectServiceTest {

    @Mock
    private ProjectDAO projectDAO;

    @InjectMocks
    private ProjectService projectService;

    private Project project;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        project = new Project();
        project.setProjectId("1");
        project.setProjectName("Sample Project");
        project.setProjectManager("manager1");
    }

    @Test
    void testCreateProject() {
        when(projectDAO.saveProject(any(Project.class))).thenReturn(true);

        boolean result = projectService.createProject(project);

        assertTrue(result);
        verify(projectDAO, times(1)).saveProject(any(Project.class));
    }


}
