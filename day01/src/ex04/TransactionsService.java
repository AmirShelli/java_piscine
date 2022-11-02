package ex04;

import java.util.UUID;

public class TransactionsService {
    UsersArrayList users = new UsersArrayList();

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
        try{
            User sender = users.getUser(senderID);
            User recipient = users.getUser(recipientID);
            Transaction transfer = new Transaction(users.getUser(recipientID), users.getUser(senderID), amount);
            sender.addTransaction(transfer);
            recipient.addTransaction(transfer);
            transfer.transfer();;
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
