package HackerEarth;

import java.util.Scanner;

public class FactorialExample
{
    public static void main(String args[] ) throws Exception
    {
        //int num = 5;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long factorial = 1;
        for(int i = 1; i <= num; ++i)
        {
            // factorial = factorial * i;
            factorial *= i;
        }
        System.out.printf("Factorial of %d = %d", num, factorial);
    }
}
