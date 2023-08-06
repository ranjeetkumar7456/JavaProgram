package JavaCode.constructor;

/*
The default constructor initializes any uninitialized instance variables with default values.

        Type	Default Value
        boolean	false
        byte	0
        short	0
        int	0
        long	0L
        char	\u0000
        float	0.0f
        double	0.0d
        object	Reference null
        In the above program, the variables a and b are initialized with default value 0 and false respectively.

        The above program is equivalent to:
*/


/*Important Notes on Java Constructors
        1. Constructors are invoked implicitly when you instantiate objects.
        2. The two rules for creating a constructor are:
           The name of the constructor should be the same as the class.
           A Java constructor must not have a return type.
        3. If a class doesn't have a constructor, the Java compiler automatically creates a default constructor during run-time. The default constructor initializes instance variables with default values. For example, the int variable will be initialized to 0
           Constructor types:
           No-Arg Constructor - a constructor that does not accept any arguments
           Parameterized constructor - a constructor that accepts arguments
           Default Constructor - a constructor that is automatically created by the Java compiler if it is not explicitly defined.
        4. A constructor cannot be abstract or static or final.
        5. A constructor can be overloaded but can not be overridden.*/

public class Default_Constructor {
    int a;
    boolean b;

    float f;

    public static void main(String[] args) {
        // A default constructor is called
        Default_Constructor obj = new Default_Constructor();

        System.out.println("Default Value:");
        System.out.println("a = " + obj.a);
        System.out.println("b = " + obj.b);
        System.out.println("f = " + obj.f);

    }
}