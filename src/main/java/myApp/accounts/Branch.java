package myApp.accounts;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Branch {
    public Queue<AccountHolder> customersQueue = new LinkedList<>();

    public void addCustomer(AccountHolder holder) {
        customersQueue.add(holder);
    }

    public Queue<AccountHolder> getCustomers() {
        return customersQueue;
    }

    public List<String> getLastNames() {            // todo apply na praktike
        return customersQueue.stream().map(a -> a.getLastName()).collect(Collectors.toList());
    }


}
