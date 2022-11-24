package ex00;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Program {

    private static final int BYTE_SIZE = 8;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private static String _rightSignature;

    public static HashMap<String, String> getSignatures() throws FileNotFoundException {
        HashMap<String, String> signatures = new HashMap<>();
        try {
            FileInputStream file = new FileInputStream("/home/mitsu/IdeaProjects/java_piscine/day02/src/ex00/signatures.txt");
            Scanner fromFile = new Scanner(file);
            do {
                String line = fromFile.next();
                if (line.contains(","))
                    line = line.substring(0, line.length() - 1);
                String key = fromFile.nextLine();
                key = key.replaceAll("\\s", "");
                System.out.println("keys = " + key);
                signatures.put(key, line);
            } while (!fromFile.hasNextInt());}
        catch (Exception ignored) {}
        return (signatures);
    }
    private static boolean isFound(HashMap<String, String> allSign, String sign) {
        for (String key : allSign.keySet()) {
            if (sign.indexOf(key) == 0) {
                _rightSignature = allSign.get(key);
                return true;
            }
        }
        return false;
    }
    public static String byteToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {

            int v = bytes[j] & 0xFF;

            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
    public static void checkFile(String path, HashMap<String, String> signatures) throws IOException {
        File file = new File(path);
        if(!(file.isFile() || file.exists() || file.canRead()))
            System.out.println("can't open file!");
        else {
            FileInputStream inputFile = new FileInputStream(file);
            byte[] buffer = new byte[BYTE_SIZE];
            inputFile.read(buffer,0,BYTE_SIZE);
            String fileSignature = byteToHex(buffer);
            System.out.println(fileSignature);
            if(isFound(signatures, fileSignature)) {
                FileWriter result = new FileWriter("result.txt", true);
                result.append(_rightSignature).append(String.valueOf('\n'));
                System.out.println("PROCESSED");
            } else {
                System.out.println("UNDEFINED");
            }
        }

    }
    public static void main(String[] args) throws IOException {
        HashMap<String, String> allSign = getSignatures();
        Scanner in = new Scanner(System.in);
        while(true) {
            _rightSignature = "";
            String path = in.nextLine();
            if(path.equals("42"))
                break;
            checkFile(path, allSign);

        }
    }
}
