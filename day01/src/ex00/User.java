package ex00;

import java.util.UUID;

public class User {
    private Integer id;
    private String name;
    private long balance;

    User(String name, long balance){
        if(balance >= 0)
            this.balance = balance;
        this.name = name;
    }

    public void changeBalance(long amount)
    {
        if(balance + amount >= 0)
            return;
        balance += amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
