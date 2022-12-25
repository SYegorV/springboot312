package com.example.service;

import com.example.model.User;
import java.util.List;

public interface UserService {

    User getById(long id);
    void addUser(User newUser);
    void deleteUser(Long id);
    void updateUser(long id, User userForUpdate);
    List<User> getUsersList();
}
