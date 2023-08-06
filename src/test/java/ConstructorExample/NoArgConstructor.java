

/*
        1. Java No-Arg Constructors
        Similar to methods, a Java constructor may or may not have any parameters (arguments).

        If a constructor does not accept any parameters, it is known as a no-argument constructor.
        For example,

                 private Constructor()
                     {
                            // body of the constructor
                     }
*/



package ConstructorExample;

public class NoArgConstructor {
    int i;


    // constructor with no parameter
    private NoArgConstructor()
    {
        i=5;
        System.out.println("Constructor is called");
    }

    public static void main(String[] args) {
        // calling the constructor without any parameter
        NoArgConstructor obj = new NoArgConstructor();
        System.out.println("Value of i: " + obj.i);
    }
}


/*
=============================== OUTPUT ===============================

Constructor is called
Value of i: 5

*/

/*

        In the above example, we have created a constructor NoArgConstructor(). Here, the constructor does not accept any parameters. Hence, it is known as a no-arg constructor.

*/