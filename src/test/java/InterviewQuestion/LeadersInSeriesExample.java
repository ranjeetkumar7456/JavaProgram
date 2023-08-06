package InterviewQuestion;


import java.util.ArrayList;
import java.util.List;

//Given a set of numbers, find the leaders in the series. (An element is a leader if it is greater than all the elements to its right).
public class LeadersInSeriesExample {


    public static List<Integer> findLeaders(int[] series)
    {
        List<Integer> leaders = new ArrayList<>();
        int maxRight = Integer.MIN_VALUE;

       /*
        Initialize a variable maxRight to store the maximum element encountered from
        the right side of the array while iterating from right to left. Set maxRight
        to Integer.MIN_VALUE initially, which represents the smallest possible integer value.
        */

        for (int i = series.length - 1; i >= 0; i--)
        {
            if (series[i] > maxRight)
            {
                leaders.add(series[i]);
                maxRight = series[i];
            }
        }

        // Reverse the list to get the original order
        List<Integer> reversedLeaders = new ArrayList<>();
        for (int i = leaders.size() - 1; i >= 0; i--)
        {
            reversedLeaders.add(leaders.get(i));
        }

        return reversedLeaders;
    }

    public static List<Integer> findLeaders1(int[] nums)
    {
        List<Integer> leaders = new ArrayList<>();
        if (nums.length > 0)
        {
            int maxRight = nums[nums.length - 1];
            leaders.add(maxRight);
            for (int i = nums.length - 2; i >= 0; i--)
            {
                if (nums[i] > maxRight)
                {
                    maxRight = nums[i];
                    leaders.add(maxRight);
                }
            }
        }
// Reverse the list to get the original order
        List<Integer> reversedLeaders = new ArrayList<>();
        for (int i = leaders.size() - 1; i >= 0; i--)
        {
            reversedLeaders.add(leaders.get(i));
        }

        return reversedLeaders;
        //return leaders;
    }


    public static void findLeaders11(int[] arr)
    {
        int n = arr.length;
        int maxRight = arr[n - 1];

        // The last element is always a leader
        System.out.print(maxRight + " ");

        // Traverse the array from right to left to find leaders
        for (int i = n - 2; i >= 0; i--)
        {
            if (arr[i] > maxRight)
            {
                maxRight = arr[i];
                System.out.print(maxRight + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        int[] series = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = findLeaders(series);
        System.out.println("Leaders in the series: " + leaders);

        //findLeaders11(series);
    }


}
