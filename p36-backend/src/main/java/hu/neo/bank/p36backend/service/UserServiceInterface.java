package hu.neo.bank.p36backend.service;

import hu.neo.bank.p36backend.model.User;

public interface UserServiceInterface {

    User createUser(User user);

    User findByUsername(String name);
}
