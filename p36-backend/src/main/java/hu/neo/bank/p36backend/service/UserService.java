package hu.neo.bank.p36backend.service;

import hu.neo.bank.p36backend.model.User;
import hu.neo.bank.p36backend.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepositoryInterface userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
