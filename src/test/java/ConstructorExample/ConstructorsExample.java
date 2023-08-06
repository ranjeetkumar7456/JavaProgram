

/*

========================== Java Constructors ============================================
In this tutorial, we will learn about Java constructors, their types, and how to use them with the help of examples.

What is a Constructor?
A constructor in Java is similar to a method that is invoked when an object of the class is created.

Unlike Java methods, a constructor has the same name as that of the class and does not have any return type. For example,

class Test {
    Test() {
        // constructor body
    }
}
Here, Test() is a constructor. It has the same name as that of the class and doesn't have a return type.

Recommended Reading: Why do constructors not return values

*/



package ConstructorExample;

public class ConstructorsExample {
    private String name;

    ConstructorsExample()
    {
        System.out.println("Constructor Called:");
        name = "Programiz";
    }

    public static void main(String[] args) {
        // constructor is invoked while
        // creating an object of the Main class
        ConstructorsExample obj = new ConstructorsExample();
        System.out.println("The name is " + obj.name);
    }
}


/*
    In the above example, we have created a constructor named Main(). Inside the constructor, we are initializing the value of the name variable.

    Notice the statement of creating an object of the Main class.

    Main obj = new Main();
    Here, when the object is created, the Main() constructor is called. And, the value of the name variable is initialized.

    Hence, the program prints the value of the name variables as Programiz.
*/

/*

 ===========================   Types of Constructor  ==================================
        In Java, constructors can be divided into 3 types:

        1. No-Arg Constructor
        2. Parameterized Constructor
        3. Default Constructor

*/
