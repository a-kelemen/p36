package hu.neo.bank.p36backend.controller;

import hu.neo.bank.p36backend.model.User;
import hu.neo.bank.p36backend.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/personal")
    public User getUser(int userId) {
        User result = null;
        User u = userService.findUserById(userId);
        if(u != null) {
            result = u;
        }
        return result;
    }

    @CrossOrigin
    @PostMapping("/registration")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User u = userService.findUserByFirstname(user.getFirstname()); //must check

        // CHECK IF USER EXISTS
        if(u != null) {
            return ResponseEntity.badRequest().build();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.ROLE_USER);

        return ResponseEntity.ok(userService.createUser(user));
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User u = userService.findUserByEmail(user.getEmail()); //must check
        if(u == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(u);
    }
}
