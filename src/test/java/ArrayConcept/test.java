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

    public static void main(String[] args) {

        int[] arr = {10,20,20,50,50,45};

        removeDuplicate(arr);

    }
}