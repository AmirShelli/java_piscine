package ex01;

public class User {
    private final Integer id;
    private String name;
    private long balance;

    User(String name, long balance){
        this.id = UserIdsGenerator.getInstance().generateId();
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

    public Integer getId() {
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
}
