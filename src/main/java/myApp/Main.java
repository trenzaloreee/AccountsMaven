package myApp;

import myApp.model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        Account debit = new DebitAccount(new AccountHolder("Alex", "Alex"), 0, 1234);
        CreditAccount credit = new CreditAccount(new AccountHolder("John", "John"), 0, 2345, 10000);
        AccountWithInterest saving = new SavingAccount(new AccountHolder("Bob", "Bob"), 0, 3456);

        AccountHolder alex = new AccountHolder("Alex", "Alex");


//        Runnable runnable = () -> {
//            System.out.println("hello");
//        };
//
//        new Thread(runnable).start();

        new Thread(() -> {
            while (true) {
                Random r = new Random();


                if (r.nextInt(2) == 1) {
                    debit.deposit(1000);
                } else {
                    debit.pay(500);
                }
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                Random r = new Random();

                if (r.nextInt(2) == 1) {
                    debit.deposit(1000);
                } else {
                    debit.pay(500);
                }
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

//        Thread threadFromClass = new MyThread();
//        threadFromClass.start();

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Enter c to check balance");
            if (s.nextLine().equals("c")) {
                System.out.println(debit.getBalance());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


// todo создать класс представляющий филиал банка. 2 очереди! на создание счета, которые сохраняются в памяти (queue = new linkedlist  )


//        myApp.AccountWithInterest saving2 = new myApp.model.SavingAccount();


//        Account debit = new DebitAccount(new AccountHolder("Alex", "Alex"), 0, 1234);
//        CreditAccount credit = new CreditAccount(new AccountHolder("John", "John"), 0, 2345, 10000);
//        AccountWithInterest saving = new SavingAccount(new AccountHolder("Bob", "Bob"), 0, 3456);
//
//        AccountHolder alex = new AccountHolder("Alex", "Alex");
//
//        System.out.println(Account.getAccount(alex));
//
//        System.out.println(alex.equals(debit));
//
//        Stream stream = new ArrayList<String>().stream();
//
//        debit.deposit(1000);
//        credit.deposit(2000);
//        ((Account) saving).deposit(3000);
//
//        debit.pay(1500);
//        credit.pay(1500);
//
//        credit.calculateCredit();
//
//        Account.printHolders();
    }
}
