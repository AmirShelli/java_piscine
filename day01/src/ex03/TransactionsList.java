package ex03;

import ex00.Transaction;

public interface TransactionsList {

    public void addTransaction();
    public void deleteTransaction(UUID ID);
    public Transaction[] toArray();

}
