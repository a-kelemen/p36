package hu.neo.bank.p36backend.service;

import hu.neo.bank.p36backend.model.User;

import java.util.Optional;

public interface UserServiceInterface {

    User createUser(User user);

    User findByUsername(String name);
}
