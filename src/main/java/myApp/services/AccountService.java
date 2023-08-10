package myApp.services;

import myApp.model.Account;
import myApp.model.AccountHolder;

public interface AccountService {
    void createAccount(AccountHolder holder, Account account);

    void pay(AccountHolder holder, double price);
}
