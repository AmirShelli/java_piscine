package edu.school21.printer.app;
import edu.school21.printer.logic.Logic;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        if (args.length < 3)
        {
            System.err.println("Wrong number of arguments");
            System.exit(-1);
        }

        char w = args[0].charAt(0);
        char l = args[1].charAt(0);
        String imageFile = args[2];

        int[][] array2D;
        try {
            array2D = Logic.seeBMPImage(imageFile, w,l);
            for (int[] i : array2D) {
                for(int j : i) {
                    System.out.print(j);
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}