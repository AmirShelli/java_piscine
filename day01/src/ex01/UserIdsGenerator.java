package ex01;

public class UserIdsGenerator {
    private static UserIdsGenerator st;
    private static int id;
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
