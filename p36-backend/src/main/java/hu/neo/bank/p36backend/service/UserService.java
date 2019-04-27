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

    /**
     *
     * @param user the user with details who wants to register
     * @return
     */
    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    /**
     *
     * @param name the name of the user who we want to get from database
     * @return
     */
    /*@Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }*/

    /**
     *
     * @param firstName firstName of user who we want to get from database
     * @return
     */
    @Override
    public User findUserByFirstname(String firstName) {

        return userRepository.findUserByFirstname(firstName);
    }

    /**
     *
     * @param id the id of user who we want to get from database
     * @return
     */
    @Override
    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
