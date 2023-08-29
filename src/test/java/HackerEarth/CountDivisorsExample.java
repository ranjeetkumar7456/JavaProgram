package HackerEarth;


/*
You have been given 3 integers - l, r and k. Find how many numbers between l and r (both inclusive) are divisible by k. You do not need to print these numbers, you just have to find their count.

        Input Format
        The first and only line of input contains 3 space separated integers l, r and k.

        Output Format
        Print the required answer on a single line.

        Constraints


        Sample Input
        1 10 1
        Sample Output
        10
        Time Limit: 1
        Memory Limit: 256
        Source Limit:
*/

public class CountDivisorsExample
{
    public static void count_number(int i, int r,int divider)
    {
        int count =0;
        for(int j=i;j<=r;j++)
        {
            if(j%divider==0)
            {
                count++;
            }
        }
        System.out.println(count);

    }
    public static void main(String[] args) throws Exception
    {
        count_number(1,10,1);
    }

}
