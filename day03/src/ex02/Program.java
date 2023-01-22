package ex02;

import java.util.ArrayList;

public class Program {


    public static void main(String[] args) {
        final int threadsCount = 10;

        MyArray arr = new MyArray();
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < threadsCount; i++) {
            threads.add(new Counter(arr, i + 1));
            threads.get(i).start();
        }
        for(int i = 0; i < threadsCount; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
