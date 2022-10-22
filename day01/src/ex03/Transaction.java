package ex03;

import ex02.User;

import java.util.UUID;

public class Transaction {
    private UUID id;
    private User recipient;
    private User sender;
    private String category;
    private long  amount;

    Transaction(User sender, User recipient, long amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount =  amount;
        this.id = UUID.randomUUID();
    }
    public void transfer(){
        recipient.changeBalance(amount);
        sender.changeBalance(-amount);
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId(){
        return this.id;
    }


}
