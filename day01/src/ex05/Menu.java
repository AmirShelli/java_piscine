package ex05;

import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Menu {

    UsersArrayList users = new UsersArrayList();
    Menu() {

    }
    private void addUser()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a user name and a balance");
        String name = s.next();
        String balance = s.next();
        User user = new User(name, Integer.parseInt(balance));
        users.addUser(user);
        System.out.println("User with id = " + user.getId() + "is added");
    }

    private  void viewBalance() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a user ID");
        String userID = s.next();
        User user = users.getUserById(Integer.parseInt(userID));
        System.out.println(user.getUserName() + " - " + user.getBalance());
    }

    private void viewAllTransactions() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a user ID");
        String userID = s.next();
        User user = users.getUserById(Integer.parseInt(userID));
        user.getUserTransactions();
    }
    public String performOption(){
        Scanner s = new Scanner(System.in);
        String option = s.next();

        switch (option){
            case "1":
                addUser();
                break;
            case "2":
                viewBalance();
                break;
            case "3":
                performTransfer();
                break;
            case "4":
                viewAllTransactions();
                break;
            case "5":
                removeTransfer();
                break;
            case "6":
                checkValidity();
                break;
            case "7":
                exit();
                break;
            default:

        }
    }
}
