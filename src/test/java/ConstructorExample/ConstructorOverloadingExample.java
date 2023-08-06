/*

        Constructors Overloading in Java :
        Similar to Java method overloading, we can also create two or more constructors with different parameters. This is called constructors overloading.

*/


package ConstructorExample;

public class ConstructorOverloadingExample {


    String language;

    // constructor with no parameter
    ConstructorOverloadingExample()
    {
        this.language = "Java";
    }

    // constructor with a single parameter
    ConstructorOverloadingExample(String language)
    {
        this.language = language;
    }

    public void getName()
    {
        System.out.println("Programming Langauage: " + this.language);
    }

    public static void main(String[] args) {
        // call constructor with no parameter
        ConstructorOverloadingExample obj1 = new ConstructorOverloadingExample();

        // call constructor with a single parameter
        ConstructorOverloadingExample obj2 = new ConstructorOverloadingExample("Python");

        obj1.getName();
        obj2.getName();
    }
}
/*

        Output:

        Programming Language: Java
        Programming Language: Python

*/
/*

        In the above example, we have two constructors: Main() and Main(String language). Here, both the
        constructor initialize the value of the variable language with different values.

        Based on the parameter passed during object creation, different constructors are called and different values are assigned.

        It is also possible to call one constructor from another constructor. To learn more, visit Java Call One Constructor from Another.

        Note: We have used this keyword to specify the variable of the class. To know more about this keyword, visit Java this keyword.

*/













