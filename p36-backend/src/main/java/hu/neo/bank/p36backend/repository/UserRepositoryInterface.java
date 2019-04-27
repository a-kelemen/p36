package hu.neo.bank.p36backend.repository;

import hu.neo.bank.p36backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryInterface extends JpaRepository<User, Integer> {

    User findById(int id);

    //User findByUsername(String name);

    User save(User user);

    User findUserByFirstname(String firstName);

    User findUserByEmail(String email);
}
