package CGI_interviewQuestion;

public class ReverseIntegerExample {
    public static void reverseInteger(int number)
    {
        int reverseNumber=0;
        while(number>0)
        {
            int digit = number%10;
            reverseNumber=reverseNumber*10+digit;
            number= number/10;
        }
        System.out.println(reverseNumber);
    }

    public static void reverseInteger_ContainingZeroAtRightSide(int number)
    {
        String no = String.valueOf(number);
        String reverseNo="";
        for(int i =no.length()-1;i>=0;i--)
        {
            reverseNo= reverseNo+no.charAt(i);
        }
        System.out.println(reverseNo.toString());

    }

    public static void reverseInteger_ContainingZeroAtRightSide1(int number)
    {
        String no = String.valueOf(number);
        char[] charArray = no.toCharArray();
        String reverseNo="";
        for(int i =charArray.length-1;i>=0;i--)
        {
            reverseNo= reverseNo+no.charAt(i);
        }
        System.out.println(reverseNo.toString());

    }

    public static void main(String[] args) {
        int number = 1234560;
        reverseInteger(number);
        reverseInteger_ContainingZeroAtRightSide(number);
        reverseInteger_ContainingZeroAtRightSide1(number);

    }
}
