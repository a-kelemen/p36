package hu.neo.bank.p36backend.service;

public interface AccountServiceInterface {

    int getAmount(int userId, int accountId);

    void increaseAmount(int userId, int amount, int accountId);

    void decreaseAmount(int userId, int amount, int accountId);

}
