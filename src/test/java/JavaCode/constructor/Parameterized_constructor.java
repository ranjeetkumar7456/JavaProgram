package JavaCode.constructor;


/*In the above example, we have created a constructor named Main().
Here, the constructor takes a single parameter. Notice the expression,

Parameterized_constructor obj1 = new Parameterized_constructor("Java");
Here, we are passing the single value to the constructor. Based on the argument passed,
the language variable is initialized inside the constructor.*/

public class Parameterized_constructor {
    String languages;

    // constructor accepting single value
    Parameterized_constructor(String lang) {
        languages = lang;
        System.out.println(languages + " Programming Language");
    }

    public static void main(String[] args) {

        // call constructor by passing a single value
        Parameterized_constructor obj1 = new Parameterized_constructor("Java");
        Parameterized_constructor obj2 = new Parameterized_constructor("Python");
        Parameterized_constructor obj3 = new Parameterized_constructor("C");
    }
}