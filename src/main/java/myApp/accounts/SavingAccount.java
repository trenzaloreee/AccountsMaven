package myApp.accounts;

import java.math.BigDecimal;

public class SavingAccount extends Account implements AccountWithInterest {
    private static int interest = 5;

    public SavingAccount(AccountHolder holder, double balance, int accountNumber) {
        super(holder, balance, accountNumber);
    }

    @Override
    public void deposit(double depositSum) {
        super.deposit(depositSum);
    }

    public void calculateSavings(){
        System.out.println("За год вы заработаете " + getBalance().multiply(BigDecimal.valueOf(interest*0.01)));
        System.out.println("Ваш баланс в конце года составит " + getBalance().multiply(new BigDecimal(calcInterest(12))));
//        System.out.println("Ваш баланс в конце года составит " + getBalance().add(getBalance().multiply(BigDecimal.valueOf(interest*0.01))));
    }

    @Override
    public double calcInterest(int months) {            // 1.05
        return (1 + interest/100/12)^months;
    }
}
