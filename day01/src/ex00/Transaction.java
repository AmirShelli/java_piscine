package ex00;

import java.util.UUID;

public class Transaction {
    private UUID id;
    private User recipient;
    private User sender;
    private String category;
    private long  amount;

    public void transfer(long amount)
    {
        recipient.changeBalance(amount);
        sender.changeBalance(-amount);
    }

}
