package ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int query;
        int count = 0;
        try{
            do {
                query = getNumber();
                if(isPrime(sum(query)))
                    count++;
            } while(query != 42);
            System.out.println(count);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgument");
        }
    }
    public static int sum(int number) {
        int sum = 0;
        for(int i = 0; i < 6; i++)
        {
            sum += number % 10;
            number /= 10;
        }
        return sum;
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
