package com.example.shishaapp.User;

import com.example.shishaapp.User.Data.UserRepository;
import com.example.shishaapp.User.Domain.User;
import com.example.shishaapp.User.Service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock // Mockito will create a mock implementation of UserRepository
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void findAll() {
        User user = new User("1234", "John Doe");
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<User> result = userService.findAll();

        assertEquals(1, result.size());
        assertEquals(user, result.get(0));
    }
}

