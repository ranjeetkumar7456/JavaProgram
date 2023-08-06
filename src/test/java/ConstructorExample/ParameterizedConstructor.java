
/*

        2. Java Parameterized Constructor
        A Java constructor can also accept one or more parameters. Such constructors are known as parameterized constructors (constructor with parameters).

*/


package ConstructorExample;

public class ParameterizedConstructor {

    String languages;

    // constructor accepting single value
    ParameterizedConstructor(String lang)
    {
        languages = lang;
        System.out.println(languages + " Programming Language");
    }

    public static void main(String[] args) {
        // call constructor by passing a single value
        ParameterizedConstructor obj1 = new ParameterizedConstructor("Java");
        ParameterizedConstructor obj2 = new ParameterizedConstructor("Python");
        ParameterizedConstructor obj3 = new ParameterizedConstructor("C");
    }
}


/*

        Output:

        Java Programming Language
        Python Programming Language
        C Programming Language

*/


/*

        In the above example, we have created a constructor named Main(). Here, the constructor takes a single parameter. Notice the expression,

        ParameterizedConstructor obj1 = new ParameterizedConstructor("Java");
        Here, we are passing the single value to the constructor. Based on the argument passed, the language variable is initialized inside the constructor.

*/

