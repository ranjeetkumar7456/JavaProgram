package HackerRank;

public class Factorial {

    // 1. Factorial Using Loop
    public static void Factorial_UsingLoop(int number)
    {
        long factorial = 1;

        for (int i = 1; i <= number; i++)
        {
            factorial = factorial * i;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);

    }

    // 2. Factorial Using While Loop
    public static void Factorial_Using_WhileLoop(int number)
    {
        long factorial = 1;
        int i=1;

        while (i <= number)
        {
            factorial = factorial * i;
            i++;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);

    }

    // 3. Factorial Using Do While Loop
    public static void Factorial_Using_Do_WhileLoop(int number)
    {
        long factorial = 1;
        int i=1;

        do
        {
            factorial = factorial * i;
            i++;
        } while (i <= number);

        System.out.println("Factorial of " + number + " is: " + factorial);
    }

    // 4. Factorial Using Recursion
    public static void Factorial_Using_Recursion(int number)
    {
        int i,fact=1;
        for(i=1;i<=number;i++)
        {
            fact=fact*i;
        }
        System.out.println("Factorial of "+number+" is: "+fact);
    }

    public static void main(String[] args) {

        // 1. Factorial Using Loop
        System.out.println("// 1. Factorial Using Loop");
        Factorial_UsingLoop(4);
        // 2. Factorial Using While Loop
        System.out.println("// 2. Factorial Using While Loop");
        Factorial_Using_WhileLoop(4);
        // 3. Factorial Using Do While Loop
        System.out.println("// 3. Factorial Using Do While Loop");
        Factorial_Using_Do_WhileLoop(4);
        // 4. Factorial Using Recursion
        System.out.println("// 4. Factorial Using Recursion");
        Factorial_Using_Recursion(4);


    }
}
