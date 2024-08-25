package com.example.controller;

import model.User;
import service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import servlet.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setName("testuser");
        user.setPassword("password");
        user.setEmail("test@example.com");
    }

    @Test
    void testRegisterUser_Success() throws Exception {
        when(userService.registerUser(any(User.class))).thenReturn(true);

        verify(userService, times(1)).registerUser(any(User.class));
    }

}
