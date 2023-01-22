package ex01;

import java.util.LinkedList;

class Farm {

    LinkedList<String> list = new LinkedList<>();
    int capacity = 2;
    int count;
    Farm(int count) {this.count = count;}
    public void produce() throws InterruptedException
    {
        while (count > 0) {
            synchronized (this)
            {
                while (list.size() == capacity)
                    wait();
                list.add("Hen");
                list.add("Egg");
                count--;
                notify();
            }
        }
    }
    public void consume() throws InterruptedException
    {
        while (count > 0) {
            synchronized (this)
            {
                while (list.size() == 0)
                    wait();
                System.out.println(list.removeFirst());
                System.out.println(list.removeFirst());
                notify();
            }
        }
    }
}
