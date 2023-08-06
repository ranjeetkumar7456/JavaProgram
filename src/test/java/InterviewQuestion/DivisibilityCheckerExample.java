package InterviewQuestion;

public class DivisibilityCheckerExample {
    public static void DivisibilityChecker(int num,int...devider)
    {
        for  (int i =0;i<devider.length;i++)
        {
            if(isDivisible(num, devider[i]))
            {
                System.out.println(num + " is divisible by "+devider[i]);
            }
            else {
                System.out.println(num + " is not divisible by "+devider[i]);
            }
        }

    }
    public static void DivisibilityChecker1(int num)
    {
        if (isDivisible(num, 8) || isDivisible(num, 16) || isDivisible(num, 32))
        {
            System.out.println(num + " is divisible by 8, 16, or 32.");
        }
        else
        {
            System.out.println(num + " is not divisible by 8, 16, or 32.");
        }
    }
    public static void devisibleChecker2(int number, int...divisible)
    {
        for(int i =0;i<divisible.length;i++)
        {
            if(number %divisible[i]==0)
            {
                System.out.println(number+" is devisible by : "+divisible[i]);
            }
            else
            {
                System.out.println(number+" is not devisible by : "+divisible[i]);
            }
        }

    }
    public static boolean isDivisible(int number, int divisor)
    {
        return number % divisor == 0;
    }
    public static void main(String[] args)
    {
        int number = 256;


        //DivisibilityChecker(number,8,3,16,32);
        //DivisibilityChecker1(number);
        int[] arr1={8,3,16,32};
        //devisibleChecker2(number,8,3,16,32);
        devisibleChecker2(number,arr1);


    }


}
