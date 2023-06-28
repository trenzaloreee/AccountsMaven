package accounts;

import java.math.BigDecimal;

public interface AccountInterface {

    void pay(double price);

    void deposit(double depositSum);

    BigDecimal getBalance();

    void setBalance(BigDecimal balance);

    int getAccountNumber();
}
