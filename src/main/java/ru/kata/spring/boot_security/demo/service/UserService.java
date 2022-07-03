package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    void save(User user);

    User findByUsername(String username);

    List<User> getAllUsers();

    User findById(long id);


    void remove(long id);


}
