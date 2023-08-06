package InterviewQuestion;

public class testingClass {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};
        int arrayLength = numbers.length;
        //System.out.println("Array length: " + arrayLength);

        String text = "Hello, World!";
        int textLength = text.length();
        //System.out.println("Text length: " + textLength);

        String[] text1 = {"Hello", "World!","Hello","India"};
        /*int textLength = text.length();
        System.out.println("Text length: " + textLength);*/

        int text1Length1 = text1[0].length();
        int textLength2 = text1.length;
        System.out.println("String Text length: " + text1Length1);
        System.out.println("Array Text length: " + textLength2);

    }
}
