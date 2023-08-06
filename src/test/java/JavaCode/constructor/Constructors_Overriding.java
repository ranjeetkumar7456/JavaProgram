package JavaCode.constructor;

/*      No, Java does not support constructor overriding. In Java, constructors cannot be overridden,
        only overloaded. This means that a subclass can have a constructor with the same name as
        its superclass, but the parameters must be different.

 */


public class Constructors_Overriding {

    Constructors_Overriding() {
        System.out.println("A");
    }
}

class B extends Constructors_Overriding {
    B() {
        super();
        System.out.println("B");
    }
}

class MethodOverridingExample {
    public static void main(String[] args) {
        Constructors_Overriding a = new Constructors_Overriding(); // Outputs "A"
        B b = new B(); // Outputs "A B"
        Constructors_Overriding b2 = new B(); // Outputs "A"
    }


}

  /*  In the above example, class B extends class A and has its own constructor.
      But when we create an object of class B using new B(), the constructor of
      class A is also called using the super() method, it's not overridden.

       Furthermore, constructor overriding does not make sense in Java because
       the constructor is responsible for creating and initializing an object,
       and the behavior of that object is determined by its class, not its parent class.
       Therefore, it is not necessary to override constructors in order to change the behavior of an object.

  */