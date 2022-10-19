package ex02;

import java.util.UUID;

public class UsersArrayList implements UsersList {
    private User[] users = new User[10];
    private int size = 0;

    @Override
    public void addUser(User user) {
        if(users.length == size){
            int length = users.length + (users.length / 2);
            User[] temp = new User[size];
            System.arraycopy(users, 0, temp, 0, size);
            users = temp;
        }
        users[size] = user;
        size++;
    }

    @Override
    public User getUser(UUID id) throws UserNotFoundException {
        try {
            for(int i = 0; i < size; i++){
                if(users[i].getId() == id)
                    return users[i];
            }
            throw new UserNotFoundException( "could not find ID " + id);
        } catch (UserNotFoundException e) {
            return null;
        }

    }

    @Override
    public User getUser(int index) {
        for(int i = 0; i < size; i++){
            if(i == index)
                return users[i];
        }
        return null;
    }

    @Override
    public int getUsersAmount() {
        return size;
    }
}
