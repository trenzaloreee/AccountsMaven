package myApp.model;

import java.math.BigDecimal;

public class CreditAccount extends Account implements AccountWithInterest {

    private int interest = 5;
    private BigDecimal creditLimit;
    private BigDecimal allDepositsSum;

    public CreditAccount(AccountHolder holder, double balance, int accountNumber, double creditLimit) {
        super(holder, balance, accountNumber);
        allDepositsSum = new BigDecimal(0);
        this.creditLimit = BigDecimal.valueOf(creditLimit);
    }


    @Override
    public void deposit(double depositSum) {
        if (getBalance().add(BigDecimal.valueOf(depositSum)).compareTo(creditLimit) <= 0){
            super.deposit(depositSum);
            allDepositsSum = allDepositsSum.add(BigDecimal.valueOf(depositSum));
            System.out.println(allDepositsSum);
        }else{
            System.out.println("Вы достигли лимита пополнений по кредиту");
        }
    }

    public void calculateCredit() {
        System.out.println("За год вы пополнили карту на " + allDepositsSum);
        System.out.println("За год вы должны будете банку " + allDepositsSum.add(allDepositsSum.multiply(BigDecimal.valueOf(interest * 0.01))));
    }


    @Override
    public double calcInterest(int months) {
        return (1 + interest/100/12)^months;
    }
}
