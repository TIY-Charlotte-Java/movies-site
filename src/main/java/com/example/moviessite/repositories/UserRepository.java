package com.example.moviessite.repositories;

import com.example.moviessite.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByNameAndPassword(String name, String password);

}
