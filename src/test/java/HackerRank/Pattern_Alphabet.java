package HackerRank;

public class Pattern_Alphabet {
   /*
    ** Printing the pattern... **
    A
    A B
    A B C
    A B C D
    A B C D E
    A B C D E F
    */
    public static void pattern1()
    {
        int alphabet = 65;
        System.out.println("** Printing the pattern... **");
        for (int i = 0; i <= 5; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print((char) (alphabet + j) + " ");
            }
            System.out.println();
        }
    }

    /*
    ** Printing the pattern... **
    A
    B B
    C C C
    D D D D
    E E E E E
    F F F F F F
    */
    public static void pattern2()
    {
        int alphabet = 65;

        System.out.println("** Printing the pattern... **");
        for (int i = 0; i <= 5; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print((char) alphabet + " ");
            }
            alphabet++;
            System.out.println();
        }
    }
    /*
       ** Printing the pattern... **
        A
        A B
        A B C
        A B C D
        A B C D E
        A B C D E F
        A B C D E
        A B C D
        A B C
        A B
        A
       */
    public static void pattern3()
    {
        System.out.println("** Printing the pattern... **");

        for (int i = 0; i <= 5; i++)
        {
            int alphabet = 65;
            for (int j = 0; j <= i; j++)
            {
                System.out.print((char) (alphabet + j) + " ");
            }
            System.out.println();
        }
        for (int i = 5; i >= 0; i--)
        {
            int alphabet = 65;
            for (int j = 0; j <= i - 1; j++)
            {
                System.out.print((char) (alphabet + j) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pattern1();
        pattern2();
        pattern3();

    }
}
