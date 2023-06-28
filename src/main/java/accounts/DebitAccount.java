package accounts;

import java.math.BigDecimal;

public class DebitAccount extends Account {
    public DebitAccount(AccountHolder holder, double balance, int accountNumber) {
        super(holder, balance, accountNumber);
    }

    @Override
    public void pay(double price) {
        if (getBalance().subtract(BigDecimal.valueOf(price)).intValue() >= 0){
            super.pay(price);
        }else {
            System.out.println("Недостаточно средств.");
        }
    }

    @Override
    public void deposit(double depositSum) {
        super.deposit(depositSum);
    }
}
