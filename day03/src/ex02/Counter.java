package ex02;

public class Counter extends Thread{
    private static final Object lock = new Object();
    private int id;
    private MyArray arr;
    Counter(MyArray arr, int id){
        this.id = id;
        this.arr = arr;
    }

    @Override
    public void run(){
        synchronized (lock) {
            int index = arr.getIndex();
            System.out.println("thread " + id + ": " + index);
            arr.updateIndex(5);
        }

    }

}
