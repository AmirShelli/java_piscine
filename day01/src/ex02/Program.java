package ex02;

public class Program {
    public static void main(String[] args) {
        UsersArrayList users = new UsersArrayList();

        users.addUser(new User("hello", 30000));
        users.addUser(new User("world", 90000));

        try {
            System.out.println("by index***");
            System.out.println(users.getUser(1).getName());

            System.out.println("by id***");
            System.out.println(users.getUser(users.getUser(0).getId()).getName());

            System.out.println("error***");
            System.out.println(users.getUser(2).getName());
        }catch(UserNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
