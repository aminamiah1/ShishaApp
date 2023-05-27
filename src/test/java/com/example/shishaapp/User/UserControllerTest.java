package com.example.shishaapp.User;

import com.example.shishaapp.User.Controller.UserController;
import com.example.shishaapp.User.Domain.User;
import com.example.shishaapp.User.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Test
    public void getAllUsers() throws Exception {
        User user = new User("1234", "John Doe");
        when(userService.findAll()).thenReturn(Collections.singletonList(user));

        // Initialize mockMvc with the userController instance
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockMvc.perform(get("/api/users") // Perform a GET request to "/api/users"
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // check that response is OK
                .andExpect(jsonPath("$[0].id", is(user.getId())))
                .andExpect(jsonPath("$[0].name", is(user.getName())));
        // Check that the response contains the expected user data
    }
}

