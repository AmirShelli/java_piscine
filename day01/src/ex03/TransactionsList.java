package ex03;

import java.util.UUID;

public interface TransactionsList {

    public void addTransaction(Transaction transaction);
    public void deleteTransaction(UUID ID);
    public Transaction[] toArray();

}
