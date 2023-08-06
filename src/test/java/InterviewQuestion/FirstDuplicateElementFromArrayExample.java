package InterviewQuestion;

import java.util.HashSet;

public class FirstDuplicateElementFromArrayExample
{
    public static int findFirstDuplicate(int[] array)
    {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : array)
        {
            if (seen.contains(num))
            {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] array = {2, 3, 4, 1, 2, 5, 3};

        int firstDuplicate = findFirstDuplicate(array);

        if (firstDuplicate != -1)
        {
            System.out.println("First duplicate: " + firstDuplicate);
        }
        else
        {
            System.out.println("No duplicate found.");
        }
    }
}
