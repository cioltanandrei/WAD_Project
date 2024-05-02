package org.example.xlr8travel.repositories;

import org.example.xlr8travel.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

        User findByUsername(String username);

        //List<User> findByRoles(String role);

}
