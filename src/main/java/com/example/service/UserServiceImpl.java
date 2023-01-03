package com.example.service;

import com.example.dto.UserForm;
import com.example.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(long id) {
        Optional<User> foundUser = usersRepository.findById(id);
        return foundUser.orElseThrow();
    }

    @Transactional
    @Override
    public void addUser(User newUser) {
        usersRepository.save(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(Long userId, UserForm updateData) {
        User userForUpdate = usersRepository.findById(userId).orElseThrow();
        userForUpdate.setName(updateData.getName());
        userForUpdate.setLastName(updateData.getLastName());
        userForUpdate.setAge(updateData.getAge());
        userForUpdate.setMail(updateData.getMail());
        usersRepository.save(userForUpdate);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsersList() {
        return usersRepository.findAll();
    }
}
