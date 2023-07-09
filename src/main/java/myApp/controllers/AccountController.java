package myApp.controllers;

import myApp.accounts.Account;
import myApp.accounts.AccountHolder;
import myApp.model.AccountWrapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @GetMapping("getAccount")
    public String getAccount(@RequestBody AccountHolder holder) {
        return Account.getAccount(holder).toString();
    }

//    @PostMapping("createAccount")     // TODO delete this and wrapper class
//    public String createAccount(@RequestBody AccountWrapper wrapper) {
//        if (Account.addAccount(wrapper.getHolder(), wrapper.getAccount()) != null) {
//    }

    @PostMapping("createAccount")
    public String createAccount(@RequestBody Account account) {
        if (Account.addAccount(account.getHolder(), account) != null) {
            return "Аккаунт добавлен успешно";
        }
            return "Аккаунт не добавлен";
    }
}
