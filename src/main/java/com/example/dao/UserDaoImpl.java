package com.example.dao;

import com.example.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.model.User;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private final UsersRepository usersRepository;

    @Autowired
    public UserDaoImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User getById(long id) {
        Optional<User> foundUser = usersRepository.findById(id);
        return foundUser.orElseThrow();
    }

    @Override
    public void addUser(User newUser) {
        usersRepository.save(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void updateUser(long id, User userForUpdate) {
        User userForUpdateData = usersRepository.findById(id).orElseThrow();
        userForUpdateData.setName(userForUpdate.getName());
        userForUpdateData.setLastName(userForUpdate.getLastName());
        userForUpdateData.setAge(userForUpdate.getAge());
        userForUpdateData.setMail(userForUpdate.getMail());
        usersRepository.save(userForUpdateData);
    }

    @Override
    public List<User> getUsersList() {
        return usersRepository.findAll();
    }
}
