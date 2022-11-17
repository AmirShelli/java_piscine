package ex00;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            FileInputStream signature = new FileInputStream("/home/mitsu/IdeaProjects/java_piscine/day02/src/ex00/signature.txt");
            byte[] buffer = new byte[signature.available()];
            signature.read(buffer, 0, buffer.length);
            FileInputStream fileToCheck = new FileInputStream(in.next());
            byte[] b = new byte[fileToCheck.available()];
            signature.read(b, 0, b.length);
            String s = new String(buffer);
            FileOutputStream result = new FileOutputStream("/home/mitsu/IdeaProjects/java_piscine/day02/src/ex00/result.txt");
            boolean checked = false;
            {
                String [] s_check = s.substring(s.indexOf(",") + 2, s.indexOf("\n")).split(" ");
                while(true){
                    int i = 0;
                    if(b[i] != Integer.parseInt(s_check[i]))
                        break;
                    if(i == s_check.length)
                        checked = true;
                    System.out.println(i);
                    i++;
                }
                s = s.substring(s.indexOf("\n"));
            } while(s.equals("") && !checked);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
