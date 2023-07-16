package myApp.controllers;

import myApp.accounts.Account;
import myApp.accounts.AccountHolder;
import myApp.accounts.DebitAccount;
import myApp.model.AccountWrapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @GetMapping("getAccount")
    public String getAccount(@RequestBody AccountHolder holder) {
        return Account.getAccount(holder).toString();
    }

    // TODO написать маппинг на метод пэй/бай

//    @PostMapping("createAccount")     // TODO delete this and wrapper class
//    public String createAccount(@RequestBody AccountWrapper wrapper) {
//        if (Account.addAccount(wrapper.getHolder(), wrapper.getAccount()) != null) {
//    }

    @PostMapping("createAccount")
    public String createAccount(@RequestBody DebitAccount account) {
        Account.addAccount(account.getHolder(), account);
        if (Account.getAccount(account.getHolder()).equals(account)) {
            return "Аккаунт добавлен успешно";
        }
        return null;
    }

    // TODO выдать баланс
}
