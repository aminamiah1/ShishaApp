package com.example.shishaapp.User.Service;

import com.example.shishaapp.User.Domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll(); // method to get all users
}