package ex01;

import ex01.User;

public class Program {
    public static void main(String[] args) {
        User bob = new User("Bob", 0);
        User tim = new User("Tim", 30000);

        System.out.println("Bob's id is " + bob.getId());
        System.out.println("Tim's id is " + tim.getId());

    }
}
