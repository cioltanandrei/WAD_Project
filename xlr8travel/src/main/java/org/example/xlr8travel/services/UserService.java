package org.example.xlr8travel.services;

import org.example.xlr8travel.domain.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findById(Long id);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAll();

    void removeUserById(Long id);

    void addUser(User user);
}
