package hu.neo.bank.p36backend.repository;

import hu.neo.bank.p36backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositoryInterface extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer id);

    User findByUsername(String name);

    User save(User user);
}
