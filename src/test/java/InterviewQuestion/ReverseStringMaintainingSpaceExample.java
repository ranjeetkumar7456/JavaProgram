package InterviewQuestion;

public class ReverseStringMaintainingSpaceExample {
    public static void reverseStringMaintainingSpace(String input)
    {
        char[] inputArray = input.toCharArray();
        char[] resulArray = new char[inputArray.length];
        for(int i=0;i< inputArray.length;i++)
        {
            if(inputArray[i]==' ')
            {
                resulArray[i]=' ';
            }
        }
        int j= resulArray.length-1;
        for(int i =0;i<inputArray.length;i++)
        {
            if(inputArray[i]!=' ')
            {
                if(resulArray[j]==' ')
                {
                    j--;
                }
                resulArray[j]=inputArray[i];
                j--;
            }
        }
        System.out.println(input+"------> "+String.valueOf(resulArray));

    }

    public static void main(String[] args) {
        reverseStringMaintainingSpace("I am not a string");
    }
}
