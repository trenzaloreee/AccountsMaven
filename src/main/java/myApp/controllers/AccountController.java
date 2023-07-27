package myApp.controllers;

import myApp.model.Account;
import myApp.model.AccountHolder;
import myApp.model.DebitAccount;
import myApp.services.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;

    @GetMapping("getAccount")
    public String getAccount(@RequestBody AccountHolder holder) {
        return Account.getAccount(holder).toString();
    }


    @GetMapping("getBalance")
    public String getBalance(@RequestBody AccountHolder holder) {
        String balance = Account.getAccount(holder).getBalance().toString();
        return balance;
    }

    @PostMapping("deposit")
    public String deposit(@RequestBody AccountHolder holder, @RequestParam double depositSum) {
        BigDecimal initialBalance = Account.getAccount(holder).getBalance();
        Account.getAccount(holder).deposit(depositSum);
        if (initialBalance.add(BigDecimal.valueOf(depositSum)).equals(Account.getAccount(holder).getBalance())) {
            return "пополненине на " + depositSum + " успешно";
        }
        return null;
    }

    @PostMapping("createAccount")
    public String createAccount(@RequestBody DebitAccount account) {
//        Account.addAccount(account.getHolder(), account); // todo
        accountService.createAccount(account.getHolder(), account);
        if (Account.getAccount(account.getHolder()).equals(account)) {
            return "Аккаунт добавлен успешно";
        }
        Account.getAccounts();
        return null;
    }

    //todo call to accountService for each method

}
