package myApp.accounts;

//import myApp.AccountInterface;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

public abstract class Account implements AccountInterface {

    private static HashMap<AccountHolder, Account> accountsMap = new HashMap<>();

    private static int numberOfAccounts;

    private BigDecimal balance;

    private int accountNumber;

    private AccountHolder holder;

    public Account() {}

    public Account(AccountHolder holder, double balance, int accountNumber) {
        this.balance = BigDecimal.valueOf(balance);
        this.accountNumber = accountNumber;
        this.holder = holder;
        numberOfAccounts++;
        accountsMap.put(holder, this);
    }

    public static Account addAccount(AccountHolder holder, Account account){
        return accountsMap.put(holder, account);
    }

    @Override
    public void pay(double price) {
        System.out.println("Ваш баланс до покупки: " + getBalance());
        setBalance(getBalance().subtract(BigDecimal.valueOf(price)));
        System.out.println("Ваш баланс после покупки: " + getBalance());
    }

    @Override
    public void deposit(double depositSum) {
        setBalance(getBalance().add(BigDecimal.valueOf(depositSum)));
        System.out.println("Ваш баланс был пополнен на " + depositSum);
        System.out.println("Ваш текущий баланс " + getBalance());
    }


    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    public AccountHolder getHolder() {
        return holder;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean equals(Object otherObject) {
        return accountNumber == ((Account) otherObject).getAccountNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "Держатель аккаунта - " + holder + "." + "\nБаланс счета: " + balance + "." + "\nНомер счета: " + accountNumber + ".";

    }

    public static void getAccounts() {
        System.out.println("Общее количество аккаунтов: " + numberOfAccounts);
    }

    public static Account getAccount(AccountHolder holder) {
        return accountsMap.get(holder);
    }

    public static void printHolders(){
        accountsMap.keySet().stream().forEach(System.out::println);
    }
}
