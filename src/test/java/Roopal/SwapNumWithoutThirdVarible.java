package Roopal;

public class SwapNumWithoutThirdVarible {

    public static void SwapNumWithoutThirdVaribleExample(int a,int b)
    {

        System.out.println("Before Swapping X = "+a+" and Y = "+b);
        int x = a;
        int y = b;
        x=a+b;
        y = x-y;
        x = x-y;
        System.out.println("After Swapping X = "+x+" and Y = "+y);
    }
    public static void main(String[] args) {

        SwapNumWithoutThirdVaribleExample(234,5645);

    }
}
