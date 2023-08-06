package Roopal;

public class ReverseStringExample {

    // 1. Reverse String

    public static void reverseString(String input)
    {
        char[] reverse= input.toCharArray();
        for(int i = reverse.length-1;i>=0;i--)
        {
            System.out.print(reverse[i]);
        }
    }


    // 2. Reverse String maintaining space
    public static void reverseStringMaintainingSpace(String input)
    {
        char[] inputArray= input.toCharArray();
        char[] resultArray = new char[inputArray.length];
        for(int i = 0;i<inputArray.length;i++)
        {
           if(inputArray[i]==' ')
           {
               resultArray[i] =' ';
           }
        }

        int j= resultArray.length-1;

        for(int i=0;i<inputArray.length;i++)
        {
             if(inputArray[i]!=' ')
             {
                 if(resultArray[j]==' ')
                 {
                     j--;
                 }
                 resultArray[j]= inputArray[i];
                 j--;
             }
        }
        System.out.println(String.valueOf(resultArray));
    }

    // 3. Reverse each word

    public static String reverseEachWord(String input)
    {
        String[] words = input.split(" ");
        String reverseWords ="";
        for(int i =0;i<words.length;i++)
        {
            String word = words[i];
            String reverseWord = "";

            for(int j=word.length()-1;j>=0;j--)
            {
                reverseWord=reverseWord+word.charAt(j);
            }
            reverseWords=reverseWords+reverseWord+" ";
        }
       return reverseWords;
    }

    public static void main(String[] args) {

        String name = "ranjeet kumar";

        // 1. Reverse String
        System.out.println("// 1. Reverse String");
        reverseString(name);

        System.out.println();


        // 2. Reverse String maintaining space
        System.out.println("// 2. Reverse String maintaining space");
        reverseStringMaintainingSpace(name);

        // 3. Reverse each word
        System.out.println("// 3. Reverse each word");
        System.out.println("Before String Reverse : "+name);
        System.out.print("After String Reverse : "+reverseEachWord(name));





    }
}
