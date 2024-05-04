package org.example.xlr8travel.services;

import org.example.xlr8travel.domain.User;
import org.example.xlr8travel.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void removeUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        // Step 2: Check if the user exists
        if (userOptional.isPresent()) {
            // User found, proceed to delete
            User user = userOptional.get();
            userRepository.delete(user);
        } else {
            // User not found, handle the scenario accordingly
            // For example, you could throw an exception or log a message
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
    }
}
