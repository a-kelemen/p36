package hu.neo.bank.p36backend.controller;

import hu.neo.bank.p36backend.model.User;
import hu.neo.bank.p36backend.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
