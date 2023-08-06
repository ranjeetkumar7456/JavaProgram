package Roopal;

public class EvenOddExample {
    public static void evenOddNumber(int number)
    {
        if(number%2==0)
        {
            System.out.println(number+" is Even");
        }
        else
        {
            System.out.println(number+" is Odd");
        }
    }

    public static void main(String[] args) {
        int no = 30;
        evenOddNumber(no);
    }
}
