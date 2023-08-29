package HackerEarth;

public class MaxProductOfThreeNumberInArrayExample
{
    // perform the bubble sort
    public static void bubbleSort(int array[])
    {
        int size = array.length;
        // loop to access each array element
        for (int i = 0; i < size - 1; i++)
        {
            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++)
            {
                // compare two adjacent elements
                // change > to < to sort in descending order
                if (array[j] > array[j + 1])
                {
                    // swapping occurs if elements
                    // are not in the intended order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }

    }
    public static void main(String[] args)
    {
        int[] data = { 4,1,5,6,9,2,3,7,8 };
        System.out.println("Before bubble sort");
        for(int i=0;i<data.length;i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.println();
        int maxProd1 =  data[data.length-1]*data[data.length-2]*data[data.length-3];
        System.out.println("max Product is : "+maxProd1);
        bubbleSort(data);
        System.out.println("After bubble sort");
        for(int i=0;i<data.length;i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.println();
        int maxProd =  data[data.length-1]*data[data.length-2]*data[data.length-2];
        System.out.println("max Product is : "+maxProd);
    }
}
