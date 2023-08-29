package StringProblems;

public class RotationOfArrayExample
{
    // Left rotated array
    public static void leftRotate(int[] arr, int d)
    {
        int n = arr.length;
        int[] temp = new int[d];

        // Store the first d elements in a temporary array
        for (int i = 0; i < d; i++)
        {
            temp[i] = arr[i];
        }

        // Shift the remaining elements to the left
        for (int i = d; i < n; i++)
        {
            arr[i - d] = arr[i];
        }

        // Copy back the elements from the temporary array
        for (int i = 0; i < d; i++)
        {
            arr[n - d + i] = temp[i];
        }
    }

    // Right rotated array
    public static void rightRotate(int[] arr, int d)
    {
        int n = arr.length;
        int[] temp = new int[d];

        // Store the last d elements in a temporary array
        for (int i = 0; i < d; i++)
        {
            temp[i] = arr[n - d + i];
        }

        // Shift the remaining elements to the right
        for (int i = n - 1; i >= d; i--)
        {
            arr[i] = arr[i - d];
        }

        // Copy back the elements from the temporary array
        for (int i = 0; i < d; i++)
        {
            arr[i] = temp[i];
        }
    }
    public static void main(String[] args)
    {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int leftRotationCount = 2; // Number of positions to rotate
        int rightRotationCount = 2; // Number of positions to rotate

        leftRotate(array1, leftRotationCount);

        System.out.println("Left rotated array:");
        for (int num : array1)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        rightRotate(array2, rightRotationCount);

        System.out.println("Right rotated array:");
        for (int num : array2)
        {
            System.out.print(num + " ");
        }
    }
}
