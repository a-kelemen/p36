package hu.neo.bank.p36backend.service;

public interface AccountServiceInterface {

    void getAmount();

    void increaseAmount(int userId, int amount);

    void decreaseAmount();

}
