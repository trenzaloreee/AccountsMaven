package myApp.services.impl;

import myApp.model.Account;
import myApp.model.AccountHolder;
import myApp.services.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void createAccount(AccountHolder holder, Account account) {
        Account.addAccount(holder, account);
    }

    @Override
    public void pay(AccountHolder holder, double price) {
        Account.getAccount(holder).pay(price);
    }

    // todo other methods
}
