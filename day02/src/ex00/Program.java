package ex00;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    public static HashMap<String, String> getSignatures() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("/home/mitsu/IdeaProjects/java_piscine/day02/src/ex00/signature.txt");
        HashMap<String, String> signatures = new HashMap<>();
        Scanner fromFile = new Scanner(file);
        while(fromFile.hasNextInt()){
            String key = fromFile.next();
            if(key.contains(","))
                key = key.substring(0, key.length() - 1);
            String line = fromFile.nextLine();
            line = line.replace("\\s", "");
            signatures.put(key, line);
        }
        return (signatures);
    }
    public static String byteToHex(byte[] byteArray)
    {
        String hex = "";
        for (byte i : byteArray) {
            hex += String.format("%02X", i);
        }
        return hex;
    }
    public static void checkFile(String path, HashMap<String, String> signatures) throws FileNotFoundException {
        File file = new File(path);
        if(!(file.isFile() || file.exists() || file.canRead()))
            System.out.println("can't open file!");
        else {
            FileInputStream inputFile = new FileInputStream(path);
            byte[] buffer = new byte[(int) file.length()];
            String fileSignature = byteToHex(Arrays.copyOfRange(buffer, 0 , 4));
            System.out.println(fileSignature);
            //signatures.get(fileSignature);

        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream result = new FileOutputStream("result.txt");
        HashMap<String, String> allSign = getSignatures();
        Scanner in = new Scanner(System.in);
        while(true) {
            String path = in.nextLine();
            if(path.equals("42"))
                break;
            checkFile(path, allSign);

        }
    }
}
