package Pattern;


/*1
2 3
4 5 6
7 8 9 10
11 12 13 14 15*/

public class NumberPattern1
{
    /*
    1
    2 3
    4 5 6
    7 8 9 10
    11 12 13 14 15
    */
    public static void pattern1(int numberOfPattern)
    {
        int counter = 1;
        //Loop to iterate over each row
        for (int i = 1; i <= numberOfPattern; i++)
        {
            //Loop to iterate over each column
            for (int j = 1; j <= i; j++)
            {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }


    /*
    1
    2 2
    3 3 3
    4 4 4 4
    5 5 5 5 5
    */
    public static void pattern2(int numberOfPattern)
    {
        for(int i=1;i<=numberOfPattern;i++){
            //Loop to iterate over each column of the ith row
            for(int j=1;j<=i;j++){
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }

    /*
    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
    */
    public static void pattern3(int numberOfPattern)
    {
        for(int i=1;i<=numberOfPattern;i++){
            //Loop to iterate over each column of the ith row
            for(int j=1;j<=i;j++){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }

    /*
    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
    1 2 3 4
    1 2 3
    1 2
    1
    */
    public static void pattern4(int numberOfPattern)
    {
        //Printing Upper Half for n rows
        //Loop to iterate over each row
        for(int i=1;i<=numberOfPattern;i++){
            //Loop to iterate over each column of the ith row
            for(int j=1;j<=i;j++){
                System.out.print(j+ " ");
            }
            System.out.println();
        }

        //Printing Lower Half for n-1 rows
        //Loop to iterate over each row in reverse order
        for(int i=numberOfPattern-1;i>=1;i--){
            //Loop to iterate over each column of the ith row
            for(int j=1;j<=i;j++){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }


    public static void main(String args[])
    {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(9 );
    }
}
