package InterviewQuestion;

public class CountDigitExample
{

    public static int CountDigit(String binaryString,char ch)
    {
        int count = 0;

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }

    public static void CountDigit1(String binaryString,char ch)
    {
        int count = 0;
        char[] character = binaryString.toCharArray();

        for (int i = 0; i < character.length; i++)
        {
            if (character[i] == ch)
            {
                count++;
            }
        }

        System.out.println("Number of " +ch +" : " + count);
    }

    public static void main(String[] args)
    {
        String str = "101100111";

        //int count = CountDigit(str,'1');
        CountDigit1(str,'1');

    }
}
