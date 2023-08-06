package JavaCode.constructor;

/*In the above example, we have two constructors: Main() and Main(String language). Here, both the constructor initialize
  the value of the variable language with different values.
  Based on the parameter passed during object creation, different constructors are called and different values are assigned.
  It is also possible to call one constructor from another constructor*/

public class Constructors_Overloading {
    String language;

    // constructor with no parameter
    Constructors_Overloading() {
        this.language = "Java";
    }

    // constructor with a single parameter
    Constructors_Overloading(String language) {
        this.language = language;
    }

    public void getName() {
        System.out.println("Programming Langauage: " + this.language);
    }

    public static void main(String[] args) {

        // call constructor with no parameter
        Constructors_Overloading obj1 = new Constructors_Overloading();

        // call constructor with a single parameter
        Constructors_Overloading obj2 = new Constructors_Overloading("Python");

        obj1.getName();
        obj2.getName();
    }
}
