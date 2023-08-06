/*

        Java Program to Call One Constructor from another

        In this example, we will learn how we can call one constructor from another constructor in Java.

        To understand this example, you should have the knowledge of the following Java programming topics:

        1. Java Constructors
        2. Java Methods

*/


package ConstructorExample;

public class CallOneConstructorFromAnother {
    int sum;

    // first constructor
    CallOneConstructorFromAnother()
    {
        // calling the second constructor
        this(5, 2);
    }

    // second constructor
    CallOneConstructorFromAnother(int arg1, int arg2)
    {
        // add two value
        this.sum = arg1 + arg2;
    }

    void display() {
        System.out.println("Sum is: " + sum);
    }

    public static void main(String[] args) {
        CallOneConstructorFromAnother obj = new CallOneConstructorFromAnother();

        // call display method
        obj.display();
    }

}

/*
        Output

        Sum is: 7
*/


/*


        In the above example, we have created a class named Main.
        Here, you have created two constructors inside the Main class.


                  Main() {..}

                  Main(int arg1, int arg2) {...}

        Inside the first constructor, we have used this keyword to call the second constructor.

        this(5, 2);

        Here, the second constructor is called from the first constructor by passing arguments 5 and 2.

        Note: The line inside a constructor that calls another constructor should be the first line of the constructor.
              That is, this(5, 2) should be the first line of Main().


*/
