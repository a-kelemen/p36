package hu.neo.bank.p36backend.service;

import hu.neo.bank.p36backend.model.User;

import java.util.Optional;

public interface UserServiceInterface {

    User createUser(User user);

    Optional<User> findByUsername(String name);
}
