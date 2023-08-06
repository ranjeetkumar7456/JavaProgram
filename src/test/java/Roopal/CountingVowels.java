package Roopal;

import java.sql.SQLOutput;

public class CountingVowels {

    public static void countVowels(String input)
    {
        int count = 0;
        for (int i=0 ; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'||ch == ' '){
                count ++;
            }
        }
        System.out.println("Number of vowels in the given sentence is "+count);
    }

    public static void countVowelsWithFrequency(String input)
    {
        int[] counters = new int[5];

        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'A')
            {
                counters[0]++;
            }
            else if (ch == 'e' || ch == 'E')
            {
                counters[1]++;
            }
            else if (ch == 'i' || ch == 'I')
            {
                counters[2]++;
            }
            else if (ch == 'o' || ch == 'O')
            {
                counters[3]++;
            }
            else if (ch == 'u' || ch == 'U')
            {
                counters[4]++;
            }
        }

        // print the frequency of each vowel
        System.out.println("Count of 'a' = " + counters[0]);
        System.out.println("Count of 'e' = " + counters[1]);
        System.out.println("Count of 'i' = " + counters[2]);
        System.out.println("Count of 'o' = " + counters[3]);
        System.out.println("Count of 'u' = " + counters[4]);
    }

    public static void countVowelsWithFrequencyWithLower_UpperCase(String input)
    {
        int[] counters = new int[10];

        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            if (ch == 'a')
            {
                counters[0]++;
            }
            else if (ch == 'A')
            {
                counters[1]++;
            }
            else if (ch == 'e' )
            {
                counters[2]++;
            }
            else if (ch == 'E')
            {
                counters[3]++;
            }
            else if (ch == 'i' )
            {
                counters[4]++;
            }

            else if (ch == 'I')
            {
                counters[5]++;
            }
            else if (ch == 'o')
            {
                counters[6]++;
            }
            else if (ch == 'O')
            {
                counters[7]++;
            }
            else if (ch == 'u')
            {
                counters[8]++;
            }

            else if (ch == 'U')
            {
                counters[9]++;
            }

        }

        // print the frequency of each vowel
        System.out.println("Count of 'a' = " + counters[0]);
        System.out.println("Count of 'A' = " + counters[1]);
        System.out.println("Count of 'e' = " + counters[2]);
        System.out.println("Count of 'E' = " + counters[3]);
        System.out.println("Count of 'i' = " + counters[4]);
        System.out.println("Count of 'I' = " + counters[5]);
        System.out.println("Count of 'o' = " + counters[6]);
        System.out.println("Count of 'O' = " + counters[7]);
        System.out.println("Count of 'u' = " + counters[8]);
        System.out.println("Count of 'U' = " + counters[9]);
    }



    public static void vowels_consonants_digits_spaces(String input) {
        int vowels = 0, consonants = 0, digits = 0, spaces = 0;

        input = input.toLowerCase();
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);

            // check if character is any of a, e, i, o, u
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ++vowels;
            }

            // check if character is in between a to z
            else if ((ch >= 'a' && ch <= 'z')) {
                ++consonants;
            }

            // check if character is in between 0 to 9
            else if (ch >= '0' && ch <= '9') {
                ++digits;
            }

            // check if character is a white space
            else if (ch == ' ') {
                ++spaces;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("White spaces: " + spaces);
    }
    public static void main(String[] args) {
        String input ="Hi how are you welcome to tutorialspoint";

        String input1 ="Hi how are you welcome to tutorialspointAAIIOOUUEEkjefqhfqervbo6yo54i6ubp476ou 4'p7ou4p;DV KJWRTWOIQOIE QV";
        countVowels(input);
        System.out.println("===============================");
        vowels_consonants_digits_spaces(input);
        System.out.println("===============================");
        countVowelsWithFrequency(input);
        System.out.println("===============================");
        countVowelsWithFrequencyWithLower_UpperCase(input1);
    }
}
