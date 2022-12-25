package com.example.dao;

import org.springframework.stereotype.Repository;
import com.example.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getById(long id) {
        return  entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User newUser) {
        entityManager.persist(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(long id, User userForUpdate) {
        User toUpdate = getById(id);
        toUpdate = entityManager.merge(userForUpdate);
    }

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = entityManager
                .createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
