package InterviewQuestion;

public class CountVowelsAndConsonantsExample {


    // Given a string find the number of vowels and consonants
    public static void CountVowelsAndConsonants(String input)
    {
        int vowelCount = 0;
        int consonantCount = 0;

        // Convert the input string to lowercase for case-insensitive matching
        //input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch))
            {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
                {
                    vowelCount++;
                }
                else
                {
                    consonantCount++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    }

    public static void CountVowelsAndConsonants1(String str)
    {
        char[] inputArray= str.toCharArray();

        int vowelCount = 0;
        int consonantCount = 0;

        // Convert the input string to lowercase for case-insensitive matching
        //input = input.toLowerCase();

        for (int i = 0; i < inputArray.length; i++)
        {
            //char ch = input.charAt(i);

            if (Character.isLetter(inputArray[i]))
            {
                if (inputArray[i] == 'a' || inputArray[i] == 'e' || inputArray[i] == 'i' || inputArray[i] == 'o' || inputArray[i] == 'u' ||inputArray[i]=='A'||inputArray[i]=='E'||inputArray[i]=='I'||inputArray[i]=='O'||inputArray[i]=='U')
                {
                    vowelCount++;
                }
                else
                {
                    consonantCount++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    }
    public static void main(String[] args) {
        String input = "Hello, World!";
        CountVowelsAndConsonants1(input);

    }
}
