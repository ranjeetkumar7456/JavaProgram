package InterviewQuestion;

public class TraverseArrayBackToFrontExample {

    public static void TraverseArrayBackToFront(int[] arr)
    {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        TraverseArrayBackToFront(arr);


    }
}
