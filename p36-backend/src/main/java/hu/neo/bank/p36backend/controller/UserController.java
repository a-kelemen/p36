package hu.neo.bank.p36backend.controller;

import hu.neo.bank.p36backend.model.User;
import hu.neo.bank.p36backend.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @PostMapping("/registration")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Optional<User> optionalUser = userService.findByUsername(user.getUsername()); //must check

        // CHECK IF USER EXISTS
        if(optionalUser.isPresent()) {

        }

        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User u = userService.findByUsername(user.getUsername()).get(); //must check
        return ResponseEntity.ok(u);
    }
}
