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

    @CrossOrigin
    @PostMapping("/registration")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Optional<User> u = userService.findByUsername(user.getUsername()); //must check

        // CHECK IF USER EXISTS
        if(u.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.ROLE_USER);

        return ResponseEntity.ok(userService.createUser(user));
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User u = userService.findByUsername(user.getUsername()).get(); //must check
        return ResponseEntity.ok(u);
    }
}
