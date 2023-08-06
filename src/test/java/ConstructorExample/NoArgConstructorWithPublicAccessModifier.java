/*
        Notice that we have declared the constructor as private.

        Once a constructor is declared private, it cannot be accessed from outside the class.
        So, creating objects from outside the class is prohibited using the private constructor.

        Here, we are creating the object inside the same class. Hence, the program is able to access the constructor.
        To learn more, visit Java Implement Private Constructor.

        However, if we want to create objects outside the class, then we need to declare the constructor as public.

*/



package ConstructorExample;

public class NoArgConstructorWithPublicAccessModifier {
    String name;

    // public constructor
    public NoArgConstructorWithPublicAccessModifier()
    {
        name = "Programiz";
    }

    public static void main(String[] args) {
        // object is created in another class
        NoArgConstructorWithPublicAccessModifier obj = new NoArgConstructorWithPublicAccessModifier();
        System.out.println("Company name = " + obj.name);
    }
}
