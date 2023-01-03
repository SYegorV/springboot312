package com.example.service;

import com.example.dto.UserForm;
import com.example.model.User;
import java.util.List;

public interface UserService {

    User getById(long id);
    void addUser(User newUser);
    void deleteUser(Long id);

    void updateUser(Long userId, UserForm updateData);

    List<User> getUsersList();
}
