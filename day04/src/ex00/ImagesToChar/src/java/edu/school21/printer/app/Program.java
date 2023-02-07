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

        int w = args[0].charAt(0) - 48;
        int l = args[1].charAt(0) - 48;
        String imageFile = args[2];

        int[][] array2D;
        try {
            array2D = Logic.seeBMPImage(imageFile, w,l);
            for (int i = 0 ; i < array2D.length; i++) {
                for(int j = 0 ; j < array2D[i].length; j++) {
                    System.out.print(array2D[j][i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}