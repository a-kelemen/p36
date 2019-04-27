package hu.neo.bank.p36backend.service;

import hu.neo.bank.p36backend.model.User;
import hu.neo.bank.p36backend.repository.AccountRepositoryInterface;
import hu.neo.bank.p36backend.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceInterface {

    @Autowired
    private AccountRepositoryInterface accountRepository;

    @Autowired
    private UserRepositoryInterface userRepository;

    /**
     * Get the HUF or EURO amount of user
     * @param userId the id of current user
     * @param accountId the id of account of the current user
     */
    @Override
    public int getAmount(int userId, int accountId) {
        int amount = 0;
        User user = userRepository.findById(userId);
        if(user != null) {

            int hufAmountId = user.getHufAccount().getId();
            int euroAmountId = user.getEuroAccount().getId();

            if(hufAmountId == accountId) {
                amount = user.getHufAccount().getAmount();
            }
            if(euroAmountId == accountId) {
                amount = user.getEuroAccount().getAmount();
            }
        }
        return amount;
    }

    /**
     * Increase the EURO or HUF account of user
     * @param accountId the id of account of the current user
     * @param amount the money what the user has received
     * @param userId the id of current user
     */
    @Override
    public void increaseAmount(int userId, int amount, int accountId) {
        User user = userRepository.findById(userId);
        if(user != null) {

            if(user.getHufAccount().getId() == accountId) {
                int currentHufAmount = user.getHufAccount().getAmount();
                if(amount > 0) {
                    currentHufAmount = currentHufAmount + amount;
                }
            }

            if(user.getEuroAccount().getId() == accountId) {
                int currentEuroAmount = user.getEuroAccount().getAmount();
                if(amount > 0) {
                    currentEuroAmount = currentEuroAmount + amount;
                }
            }
        }
    }

    /**
     * Decrease the EURO or HUF account of user
     * @param accountId the id of account of the current user
     * @param amount the money what the user has sent
     * @param userId the id of current user
     */
    @Override
    public void decreaseAmount(int userId, int amount, int accountId) {
        User user = userRepository.findById(userId);
        if(user != null) {

            if(user.getHufAccount().getId() == accountId) {
                int currentHufAmount = user.getHufAccount().getAmount();
                if((currentHufAmount - amount) > 0) {
                    currentHufAmount = currentHufAmount - amount;
                }
            }

            if(user.getEuroAccount().getId() == accountId) {
                int currentEuroAmount = user.getEuroAccount().getAmount();
                if((currentEuroAmount - amount) > 0) {
                    currentEuroAmount = currentEuroAmount - amount;
                }
            }
        }
    }
}
