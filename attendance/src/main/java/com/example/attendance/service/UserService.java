package com.example.attendance.service;

import com.example.attendance.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);
}
