package Roopal;

public class ArmstrongNumberExample {

    public static void armstrongNumber(int number)
    {
        int input = number;
        int noCount = String.valueOf(number).length();
        int sum = 0;
        while(input!=0)
        {
            int last_digit = input%10;
            int LastDIgitToThePower =1;
            for(int i=0;i<noCount;i++)
            {
                LastDIgitToThePower=LastDIgitToThePower*last_digit;
            }
            sum=sum+LastDIgitToThePower;
            input = input/10;
        }
        if(sum==number)
        {
            System.out.println(number+ " is armstrong");
        }
        else
        {
                System.out.println(number+ " is not armstrong");
        }
        //System.out.println(sum);
    }

    public static void main(String[] args) {

        armstrongNumber(153);

    }
}
