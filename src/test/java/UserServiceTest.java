import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import dao.UserDAO;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.UserService;

public class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        // Arrange
        User user = new User();
        // Mock the DAO call
        when(userDAO.saveUser(any(User.class))).thenReturn(true);

        // Act
        boolean result = userService.updateUser(user);

        // Assert
        assertTrue(result);
        verify(userDAO).saveUser(user);
    }
}
