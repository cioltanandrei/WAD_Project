package org.example.xlr8travel.services;

import org.example.xlr8travel.domain.User;

public interface UserService {
    void save(User user);
    User findById(Long id);

    User findByUsername(String username);
}
