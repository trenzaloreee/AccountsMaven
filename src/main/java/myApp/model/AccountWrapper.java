package myApp.model;

import myApp.accounts.Account;
import myApp.accounts.AccountHolder;

public class AccountWrapper {
    private Account account;
    private AccountHolder holder;



    public Account getAccount() {
        return account;
    }

    public AccountHolder getHolder() {
        return holder;
    }
}
