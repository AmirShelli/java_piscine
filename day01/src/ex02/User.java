package ex02;

import java.util.UUID;

public class User {
    private final UUID id;
    private String name;
    private long balance;

    public User(String name, long balance){
        id = UUID.randomUUID();
        if(balance >= 0)
            this.balance = balance;
        this.name = name;
    }

    public void changeBalance(long amount)
    {
        if(balance + amount < 0)
            return;
        balance += amount;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(long balance){
        if(balance >= 0)
            this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setName() {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class UserIdsGenerator {
        private static UserIdsGenerator st;
        private int id;
        private UserIdsGenerator(){
            id = 0;
        }
        public static UserIdsGenerator getInstance() {
            if(st == null)
                st = new UserIdsGenerator();
            return st;
        }
        final int generateId(){
            id++;
            return id;
        }
    }
}
