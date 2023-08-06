/*

        3. Java Default Constructor

        If we do not create any constructor, the Java compiler automatically
        create a no-arg constructor during the execution of the program.
        This constructor is called default constructor.

*/



package ConstructorExample;

public class DefaultConstructorExample {
    int a;
    boolean b;

    public static void main(String[] args) {
        // A default constructor is called
        DefaultConstructorExample obj = new DefaultConstructorExample();

        System.out.println("Default Value:");
        System.out.println("a = " + obj.a);
        System.out.println("b = " + obj.b);
    }
}

/*

        Output:

        Default Value:
        a = 0
        b = false
*/


/*


        Here, we haven't created any constructors. Hence, the Java compiler automatically creates the default constructor.

        The default constructor initializes any uninitialized instance variables with default values.

        Type	                             Default Value
        boolean	                             false
        byte	                             0
        short	                             0
        int	                                 0
        long	                             0L
        char	                             \u0000
        float	                             0.0f
        double	                             0.0d
        object	                             Reference null

        In the above program, the variables a and b are initialized with default value 0 and false respectively.

        The above program is equivalent to:

         class Main {

                   int a;
                   boolean b;

               Main() {
                   a = 0;
                   b = false;
              }

          public static void main(String[] args) {
               // call the constructor
               Main obj = new Main();

               System.out.println("Default Value:");
               System.out.println("a = " + obj.a);
               System.out.println("b = " + obj.b);
           }
        }


        The output of the program is the same as Above Example.

*/
