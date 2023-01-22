package ex00;

import java.util.Arrays;

public class Program {
    public static Integer COUNT = -1;
    public static void main(String[] args) {
        if (getCount(args) < 1){
            System.err.println("flag --count='int > 0' is required");
            System.exit(-1);
        }

        int count = getCount(args);
        Dispute hen = new Dispute("Hen", count);
        Dispute egg = new Dispute("Egg", count);

        hen.start();
        egg.start();
        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < COUNT; i++)
            System.out.println("Human");
    }

    public static Integer getCount(String[] args) {
        if (!args[0].startsWith("--count="))
            return COUNT;
        try {
            COUNT = Integer.parseInt(args[0].substring(8));
        } catch (NumberFormatException e){
            return -1;
        }
        return COUNT;
    }
}