package ex01;

import java.util.Scanner;

import static java.lang.System.exit;

public class Program {
    public static void main(String[] args) {
        int number;
        int count;
        boolean flag = true;
        try{
            number = Program.getNumber();
            count = 0;
            for (int i = 2; i <= number/2 || number == 2; i++)
            {
                count++;
                if (number % i == 0){
                    flag = false;
                    break;
                }
            }
            System.out.printf("%b %d", flag, count);
        } catch(IllegalArgumentException e) {
            System.out.println("IllegalArgument");
            exit(-1);
        }
    }

    public static int getNumber() throws IllegalArgumentException{
        Scanner s = new Scanner(System.in);

        int number = s.nextInt();
        if(number <= 1)
            throw new IllegalArgumentException("hello");
        return number;
    }

    public static Boolean isPrime(int number){
        boolean flag = true;
        for (int i = 2; i <= number/2 || number == 2; i++) {
            if (number % i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
