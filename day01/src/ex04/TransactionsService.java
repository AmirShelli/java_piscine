package ex04;

import java.util.UUID;

public class TransactionsService {
    UsersArrayList users = new UsersArrayList();
    TransactionsLinkedList transactions = new TransactionsLinkedList();

    void addUser(String name, long balance)
    {
        users.addUser(new User(name, balance));
    }

    long getBalance(UUID id)
    {
        try {
            return(users.getUser(id).getBalance());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void transfer(UUID senderID, UUID recipientID, long amount)
    {
        transactions.addTransaction(new Transaction(users.getUser(senderID)),
                new Transaction(users.getUser(recipientID), amount));
    }
}
