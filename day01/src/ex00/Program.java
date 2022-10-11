package ex00;

public class Program {
    public static void main(String[] args) {
        User bob = new User("Bob", 0);
        User tim = new User("Tim", 30000);
        Transaction sample = new Transaction();

        sample.setRecipient(bob);
        sample.setSender(tim);
        sample.setAmount(30000);


    }
}
