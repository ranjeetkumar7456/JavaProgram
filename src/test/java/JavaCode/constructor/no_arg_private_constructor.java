package JavaCode.constructor;

/*In the above example, we have created a constructor no_arg_private_constructor(). Here, the constructor
does not accept any parameters. Hence, it is known as a no-arg constructor.Notice that we have declared the constructor as private.
Once a constructor is declared private, it cannot be accessed from outside the class. So, creating
objects from outside the class is prohibited using the private constructor.
Here, we are creating the object inside the same class. Hence, the program
is able to access the constructor. To learn more, visit Java Implement Private Constructor.
However, if we want to create objects outside the class, then we need to declare the constructor as public.*/

public class no_arg_private_constructor {
    int i;
    // constructor with no parameter
    private no_arg_private_constructor() {
        i = 5;
        System.out.println("Constructor is called");
    }

    public static void main(String[] args) {

        // calling the constructor without any parameter
        no_arg_private_constructor obj = new no_arg_private_constructor();
        System.out.println("Value of i: " + obj.i);
    }
}
