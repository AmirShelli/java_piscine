package ex03;


import ex02.User;
import ex02.UserNotFoundException;
import ex02.UsersArrayList;

public class Program {
    public static void main(String[] args) {
        TransactionsLinkedList transactions = new TransactionsLinkedList();
        UsersArrayList users = new UsersArrayList();

        users.addUser(new User("hello", 30000));
        users.addUser(new User("world", 90000));
        try{
        transactions.addTransaction(new Transaction(users.getUser(0), users.getUser(1), 300));
        transactions.addTransaction(new Transaction(users.getUser(1), users.getUser(0), 6000));
        }catch (UserNotFoundException ignored)
        {

        }

        Transaction[] transactionArray = transactions.toArray();
        System.out.println(transactionArray[0].getId());
        System.out.println(transactionArray[1].getId());
    }
}
