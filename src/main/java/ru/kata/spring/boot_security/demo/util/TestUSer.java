
package ru.kata.spring.boot_security.demo.util;

import javax.annotation.PostConstruct;


import org.springframework.stereotype.Component;

import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;


import ru.kata.spring.boot_security.demo.service.UserService;


@Component
public class TestUSer {

    private final UserService userService;

    public TestUSer(UserService userService) {
        this.userService = userService;
    }


    @PostConstruct
    private void initialize(){
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        userService.saveRole(role1);
        userService.saveRole(role2);


        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        user1.setEmail("admin@example.com");
        user1.addRole(role1);


        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword("user");
        user2.setEmail("user@example.ru");
        user2.addRole(role2);

        userService.save(user1);
        userService.save(user2);


    }


}