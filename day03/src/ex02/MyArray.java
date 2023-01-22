package ex02;

import java.util.ArrayList;

public class MyArray{
    private static volatile int index;
    private final int arraySize = 100;
    private ArrayList<Integer> integers = new ArrayList<>();
    MyArray() {
        for (int i = 0; i < arraySize; i++)
            integers.add( (int)(Math.random() * arraySize));
        index = 0;
    }

    synchronized public int getIndex() {
        return index;
    }

    synchronized public void updateIndex(int incr) {
        index += incr;
    }

}
