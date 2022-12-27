package ex01;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Program {
    public static ArrayList<String> dictionary = new ArrayList<>();

    public static void scanInto(Scanner s){
        String word;
        while(s.hasNext()) {
            word = s.next();
            if(!dictionary.contains(word))
                dictionary.add(word);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String compare = in.nextLine();
        String comparedTo = in.nextLine();
        try(        FileReader fileToCompare = new FileReader(compare);
                    FileReader fileToCompareWith = new FileReader(comparedTo)) {
            Scanner first = new Scanner(fileToCompare);
            Scanner second = new Scanner(fileToCompareWith);
            scanInto(first);
            scanInto(second);
            Vector<Integer> firstVector = new Vector<>();
            Vector<Integer> secondVector = new Vector<>();
            

        }
    }
}
