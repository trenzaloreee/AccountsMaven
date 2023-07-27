package myApp.services;

import myApp.model.Account;
import myApp.model.AccountHolder;

public interface AccountService {
    Account createAccount(AccountHolder holder, Account account);
}
