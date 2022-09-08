package ex02;

import ex01.Program;

public class Program {
    public static void main(String[] args) {
        int query;
        int count = 0;
        try{
            do {
                query = ex01.Program.getNumber();
                if(ex01.Program.isPrime(ex00.Program.sum(query)))
                    count++;
            } while(query != 42);
            System.out.println(count);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgument");
        }
    }
}
