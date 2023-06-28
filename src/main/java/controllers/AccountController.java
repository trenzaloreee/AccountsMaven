package controllers;

import accounts.Account;
import accounts.AccountHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("getAccount")
    public String getAccount(@RequestParam int temporary) {
        return "this is your account";

//        return Account.getAccount(holder).toString();
    }
}
