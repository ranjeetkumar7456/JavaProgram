package InterviewQuestion;

public class FirstRepeatedElementInArrayExample {

    public static int findFirstRepeatedElement(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] == arr[j])
                {
                    return arr[i];
                }
            }
        }

        return -1; // No repeated elements found
    }
    public static void firsteRepeated(int[] arr)
    {
        for(int i =0;i<arr.length-1;i++)
        {
            for(int j =i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    System.out.println("First Repeated element is : "+arr[i]);
                }

            }
            break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 8, 2, 9, 4, 6}; // Example array

        int firstRepeated = findFirstRepeatedElement(arr);

        if (firstRepeated != -1) {
            System.out.println("First repeated element: " + firstRepeated);
        } else {
            System.out.println("No repeated elements found");
        }

        //firsteRepeated(arr);
    }


}
