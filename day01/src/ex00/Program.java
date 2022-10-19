package ex00;

public class Program {
    public static void main(String[] args) {
        User bob = new User("Bob", 0);
        User tim = new User("Tim", 30000);
        Transaction sample = new Transaction(tim, bob, 30000);

        System.out.println("Bob has " + bob.getBalance() + " in balance before the transaction.");
        System.out.println("Tim has " + tim.getBalance() + " in balance before the transaction.");

        sample.transfer();
        System.out.println("\ntransaction loading...\n");

        System.out.println("Bob has " + bob.getBalance() + " in balance after the transaction.");
        System.out.println("Tim has " + tim.getBalance() + " in balance after the transaction.");


    }
}
