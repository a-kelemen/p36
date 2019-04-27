package hu.neo.bank.p36backend.repository;

import hu.neo.bank.p36backend.model.EuroAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositoryInterface extends JpaRepository<EuroAccount, Integer> {

}
