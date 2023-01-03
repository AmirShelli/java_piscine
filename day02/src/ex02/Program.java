package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {

    public static String read(Process p)
    {
        try(BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()))){
            StringBuilder result = new StringBuilder();
            String s;
            while ((s = stdInput.readLine()) != null)
                result.append(s);
            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void launchLS() throws IOException {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("ls");
//        commands.add("-l");
        commands.add("/home/mitsu");

        ProcessBuilder pb = new ProcessBuilder(commands);
        Process process = pb.start();
        String result = read(process);
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        launchLS();
    }
}
