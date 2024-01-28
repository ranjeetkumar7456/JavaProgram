package StringProblems;

public class SubStringSearchExample
{
    public static void main(String[] args) {
        String mainString = "Hello, world!";
        String subString = "world";

        int result = searchSubstring(mainString, subString);

        if (result != -1) {
            System.out.println("Substring found at index " + result);
        } else {
            System.out.println("Substring not found");
        }
    }

    public static int searchSubstring(String mainString, String subString) {
        return mainString.indexOf(subString);
    }
}
