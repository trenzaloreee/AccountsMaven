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

    public AccountController() {
        this.accountService = new AccountServiceImpl();
    }

    @GetMapping("getAccount")
    public String getAccount(@RequestBody AccountHolder holder) {
        return Account.getAccount(holder).toString();
    }

    public Account getAccountAsObject(AccountHolder holder){
        return Account.getAccount(holder);
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

    @GetMapping("getAllAccounts")
    public String getAllAccounts() {
        return Account.getAllAccounts().toString();
    }

    @PostMapping("createAccount")
    public String createAccount(@RequestBody Account account) {
//        Account.addAccount(account.getHolder(), account); // todo
        accountService.createAccount(account.getHolder(), account);

        if (Account.getAccount(account.getHolder()).equals(account)) {
            return "Аккаунт добавлен успешно";
        }

        return "Аккаунт не добавлен";
    }

    @PostMapping("pay")
    public String pay(@RequestBody AccountHolder holder, @RequestParam double price) {
        BigDecimal initialBalance = Account.getAccount(holder).getBalance();
        try {
            accountService.pay(holder, price);
        } catch (Exception e) {
            return e.toString();
        }
        BigDecimal newBalance = Account.getAccount(holder).getBalance();

        if ((newBalance.add(BigDecimal.valueOf(price))).equals(initialBalance)) {
            return "Прошла оплата на " + price;
        }
        return "Что-то пошло не так. Баланс: " + newBalance;
    }


    //todo call to accountService for each method

}
