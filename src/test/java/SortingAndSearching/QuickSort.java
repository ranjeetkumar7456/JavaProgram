package SortingAndSearching;

public class QuickSort
{
    public static void quickSort(int[] array, int low, int high)
    {
        if (low < high)
        {
            int partitionIndex = partition(array, low, high);

            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high)
    {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++)
        {
            if (array[j] <= pivot)
            {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printArray(int[] array)
    {
        for (int value : array)
        {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] array = {5, 3, 7, 1, 8, 2, 9, 4, 6};

        System.out.println("Original Array:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted Array:");
        printArray(array);
    }
}
