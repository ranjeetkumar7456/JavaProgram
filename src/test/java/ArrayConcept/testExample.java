package ArrayConcept;

public class testExample {

    public static void longestSubString(String str)
    {
        String longestSubString1="";
        String[] subString = str.split(" ");
        if(subString.length==1)
        {
            System.out.println("Longest Substring is length is : "+str.length());
            System.out.println("Longest Substring is : "+str);
        }
        else
        {
            int length=0;

            for(int i=0;i<subString.length;i++)
            {
                if(subString[i].length()>length)
                {
                    length= subString[i].length();
                    longestSubString1=subString[i];
                }
            }
            System.out.println("Length of Longest String is : "+longestSubString1.length());
            System.out.println("Longest String is : "+longestSubString1);
        }
    }

    // find Lowest and maximum value in array
    public static void maxMinInArray(int[] arr)
    {
        if(arr.length<2)
        {
            System.out.println("Please provide valid array");
        }
        else if(arr.length==2)
        {
            if(arr[0]!=arr[1])
            {
                if(arr[0]>arr[1])
                {
                    System.out.println("Max value in the array is = "+arr[0]);
                    System.out.println("Min value in the array is = "+arr[1]);
                }
                else
                {
                    System.out.println("Max value in the array is = "+arr[1]);
                    System.out.println("Min value in the array is = "+arr[0]);
                }
            }

        }
        if(arr.length>2)
        {
            int min = arr[0];
            int max = arr[0];
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]>max)
                {
                    max=arr[i];
                }
                else if (arr[i]<min)
                {
                    min=arr[i];
                }
            }
            System.out.println("Max value in the array is = "+max);
            System.out.println("Min value in the array is = "+min);
        }
    }

    public static void main(String[] args) {
        /*String str= "I love my india and We lived in the india. Ranjeet is going to the templeOfShivJiMandir";
        longestSubString(str);*/

        int [] arr= {4,34,5,6,7,8,9,0,33,22,11,44,55,66,77,88,-1};
        System.out.println(arr.length);
        maxMinInArray(arr);
    }
}
