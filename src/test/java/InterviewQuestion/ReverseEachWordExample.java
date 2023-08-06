package InterviewQuestion;

public class ReverseEachWordExample {
    public static void reverseEachWord(String input)
    {
        String[] words = input.split(" ");
        String reverseWords="";
        for(int i =0;i<words.length;i++)
        {
            String word = words[i];
            String reverseWord ="";
            for(int j=word.length()-1;j>=0;j--)
            {
                reverseWord+=word.charAt(j);
            }
            reverseWords+=reverseWord+" ";
        }
        System.out.println(input);
        System.out.println(reverseWords);
    }

    public static void main(String[] args) {
        reverseEachWord("Java Concept of the day");
    }
}
