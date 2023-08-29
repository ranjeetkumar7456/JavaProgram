package StringProblems;

public class test {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int rotationCount = 2; // Number of positions to rotate

        leftRotate(array, rotationCount);

        System.out.println("Left rotated array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[d];

        // Store the first d elements in a temporary array
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        // Shift the remaining elements to the left
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        // Copy back the elements from the temporary array
        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }
    }
}
