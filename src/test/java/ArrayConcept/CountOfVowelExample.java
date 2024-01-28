package ArrayConcept;

public class CountOfVowelExample
{
    public static void countVowel(String str)
    {
        int count =0;
        for(int i =0 ;i<str.length();i++)
        {
            if(str.charAt(i)=='a' || str.charAt(i)=='e' ||str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u' || str.charAt(i)=='A' || str.charAt(i)=='E' || str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U')
            {
                System.out.println(str.charAt(i));
                count++;
            }
        }

    }

    public static void countVowelFrequency(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U')
            {
                
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        countVowel("aenjioucmkjauie");
    }
}
