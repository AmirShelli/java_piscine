package ex02;

import java.util.UUID;

public interface UsersList {
    public void addUser(User user);
    public User getUser(UUID id) throws UserNotFoundException;
    public User getUser(int index) throws UserNotFoundException;
    public int getUsersAmount();
}
