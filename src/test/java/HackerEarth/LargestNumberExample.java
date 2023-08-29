package HackerEarth;

public class LargestNumberExample
{
    public static void largestNumber(int number_N, int countDigit_D,int removeDigit_K)
    {
        int newNumber=0;
        int num=number_N;
        for(int i=0;i<countDigit_D;i++)
        {
            int digit = num%10;
            while(num>0)
            {
                if(digit!=removeDigit_K)
                {
                    newNumber= newNumber*10+digit;
                    num=num/10;
                }

            }
        }
        System.out.println(newNumber);
    }

    public static void main(String[] args)
    {
        largestNumber(1234,4,1);
    }
}
