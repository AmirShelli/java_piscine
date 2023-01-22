package ex01;

public class Program {
    public static void main(String[] args)
            throws InterruptedException {
        final Farm farm = new Farm(getCount(args));
        Thread t1 = new Thread(() -> {
            try {
                farm.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                farm.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    public static Integer getCount(String[] args) {
        int count = -1;
        if (!args[0].startsWith("--count="))
            return count;
        try {
            count = Integer.parseInt(args[0].substring(8));
        } catch (NumberFormatException e){
            return -1;
        }
        return count;
    }
}