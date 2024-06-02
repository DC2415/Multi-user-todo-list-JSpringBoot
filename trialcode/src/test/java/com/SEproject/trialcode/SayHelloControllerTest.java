package com.SEproject.trialcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;

import com.SEproject.trialcode.hello.SayHelloController;

import static org.mockito.Mockito.*;

class SayHelloControllerTest {

	private SayHelloController sayHelloController;

    @Mock
    private Authentication authentication;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sayHelloController = new SayHelloController();
    }

    @Test
    public void testSayHelloJsp() {
        ModelMap model = new ModelMap();

        // Mock the getLoggedinusername() method
        String loggedinUsername = "rohan";
        when(authentication.getName()).thenReturn(loggedinUsername);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String viewName = sayHelloController.SayHelloJsp(model);

        // Verify that the model contains the username attribute
        Assertions.assertEquals(loggedinUsername, model.get("username"));

        // Verify that the returned view name is "welcome"
        Assertions.assertEquals("welcome", viewName);
    }

    @Test
    public void testGetLoggedinusername() {
        // Mock the authentication object
        String username = "rohan";
        when(authentication.getName()).thenReturn(username);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String loggedinUsername = sayHelloController.getLoggedinusername();

        // Verify that the returned username matches the authenticated username
        Assertions.assertEquals(username, loggedinUsername);
    }

}
