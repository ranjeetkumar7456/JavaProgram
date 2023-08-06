package Sorting;



public class BinarySearch
{
    // Binary search method to find the index of a target element in a sorted array
    public static int binarySearch(int[] array, int target) {
        int low = 0;                 // Starting index of the search space
        int high = array.length - 1; // Ending index of the search space

        while (low <= high)
        {
            int mid = low + (high - low) / 2; // Calculate the middle index
            if (array[mid] == target)
            {
                return mid; // Target element found, return the index
            }
            else if (array[mid] < target)
            {
                // Target element is in the right half of the array
                low = mid + 1;
            }
            else
            {
                // Target element is in the left half of the array
                high = mid - 1;
            }
        }
        return -1; // Target element not found, return -1
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 8;

        int index = binarySearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
