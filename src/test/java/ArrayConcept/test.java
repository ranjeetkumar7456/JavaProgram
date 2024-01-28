package ArrayConcept;

public class test {
    public static void removeDuplicate(int[] arr)
    {
        int index=0;
        int count;
        int[] newArray= new int[arr.length];
        System.out.println("Before removing duplicate from the array:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        // removing duplicate
        for(int i=0;i<arr.length;i++)
        {
            count=0;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    count=count+1;
                    break;
                }

            }
            if(count==0)
            {
                newArray[index]=arr[i];
                index++;
            }
        }
        for(int i=0;i<index;i++)
        {
            arr[i]=newArray[i];
        }
        System.out.println();
        System.out.println("After removing duplicate from the array");
        for(int i=0;i<index;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static boolean isPalindrome(int number) {
        char[] charArray = String.valueOf(number).toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int nearestPalindrome(int number) {
        if (isPalindrome(number)) {
            return number;
        }

        int smallestPalindrome = number - 1;
        while (!isPalindrome(smallestPalindrome)) {
            smallestPalindrome--;
        }

        int largestPalindrome = number + 1;
        while (!isPalindrome(largestPalindrome)) {
            largestPalindrome++;
        }

        // Compare the differences and return the nearest palindrome
        int diffSmallest = number - smallestPalindrome;
        int diffLargest = largestPalindrome - number;
        if (diffSmallest < diffLargest) {
            return smallestPalindrome;
        } else {
            return largestPalindrome;
        }
    }
    public static void reverse(int number)
    {
        int reverse=0;
        while (number!=0)
        {
            int digit = number%10;
            reverse = reverse*10+digit;
            number=number/10;
        }
        System.out.println(reverse);
    }
    public static void reverInteger(int number)
    {
        String no= String.valueOf(number);
        String reverse="";
        for(int i = no.length()-1;i>=0;i--)
        {
            reverse=reverse+no.charAt(i);
        }
        System.out.println(reverse);
    }

    public static void main(String[] args) {

        //int[] arr = {10,20,20,50,50,45};

        //removeDuplicate(arr);

        int number = 19;
        int numbers=1234567890;
        //int nearestPalindromeNumber = nearestPalindrome(number);
        //System.out.println("Nearest Palindrome of " + number + " is: " + nearestPalindromeNumber);
        reverse(numbers);
        reverInteger(numbers);
    }
}