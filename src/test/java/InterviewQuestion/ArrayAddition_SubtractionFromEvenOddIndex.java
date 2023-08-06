package InterviewQuestion;

public class ArrayAddition_SubtractionFromEvenOddIndex
{
    public static void subtract_a_number_M_from_every_odd_index_and_N(int[] arr,int substract_M, int substract_N)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (i % 2 == 0)
            {
                arr[i] -= substract_N; // Subtract N from even index
            } else {
                arr[i] -= substract_M; // Subtract M from odd index
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int M = 5;
        int N = 7;

        subtract_a_number_M_from_every_odd_index_and_N(array, M, N);

        // Print the modified array
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    /*public static void subtractFromArray(int[] array, int M, int N) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] -= N; // Subtract N from even index
            } else {
                array[i] -= M; // Subtract M from odd index
            }
        }
    }*/
}
