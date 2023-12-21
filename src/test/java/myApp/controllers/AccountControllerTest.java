package myApp.controllers;

import myApp.model.Account;
import myApp.model.AccountHolder;
import myApp.model.DebitAccount;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class AccountControllerTest {
        AccountController controller;
        AccountHolder holder;
        Account debitAccount;


    @BeforeAll
    public void init() {
        controller = new AccountController();
        holder = new AccountHolder("LastName", "FirstName");
        debitAccount = new DebitAccount(holder, 1000, 1234);
    }


    @Test
    public void createAccountTest() {
        controller.createAccount(debitAccount);

        Assertions.assertEquals(debitAccount, controller.getAccountAsObject(holder));
    }

    @Test
    public void nullAccountTest() {
        Assertions.assertNull(controller.getAccountAsObject(holder));
    }
}
