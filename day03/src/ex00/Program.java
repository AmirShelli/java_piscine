package ex00;

import java.util.Arrays;

public class Program {
    public static Integer COUNT = -1;
    public static void main(String[] args) {
        Arrays.stream(args).forEach(System.out::println);
        if (getCount(args) < 1){
            System.err.println("flag --count='int > 0' is required");
            System.exit(-1);
        }

        int count = getCount(args);
        Thread hen = new Dispute("Hen", count);
        Thread egg = new Dispute("Egg", count);

        hen.start();
        egg.start();
        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Integer getCount(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count="))
            return COUNT;
        try {
            COUNT = Integer.parseInt(args[0].substring(8));
        } catch (NumberFormatException e){
            return -1;
        }
        return COUNT;
    }
}