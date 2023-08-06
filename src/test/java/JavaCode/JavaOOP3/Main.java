package JavaCode.JavaOOP3;



/*Java Nested and Inner Class
        In this tutorial, you will learn about the nested class in Java and its types with the help of examples.

        In Java, you can define a class within another class. Such class is known as nested class. For example,

class OuterClass {
    // ...
    class NestedClass {
        // ...
    }
}
    There are two types of nested classes you can create in Java.

        Non-static nested class (inner class)
        Static nested class

        Recommended reading:
        1. Java Access Modifiers
        2. Java Static Keyword
        3. Let's first look at non-static nested classes.

        Non-Static Nested Class (Inner Class)
        A non-static nested class is a class within another class. It has access to members of the enclosing class (outer class). It is commonly known as inner class.

        Since the inner class exists within the outer class, you must instantiate the outer class first, in order to instantiate the inner class.

        Here's an example of how you can declare inner classes in Java.

        Example 1: Inner class*/

// nested protected class
class InnerClass {
    double price;
    // nested class
    class Processor{

        // members of nested class
        double cores;
        String manufacturer;

        double getCache(){
            return 4.3;
        }
    }

    // nested protected class
    protected class RAM{

        // members of protected nested class
        double memory;
        String manufacturer;

        double getClockSpeed(){
            return 5.5;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // create object of Outer class CPU
        InnerClass cpu = new InnerClass();

        // create an object of inner class Processor using outer class
        InnerClass.Processor processor = cpu.new Processor();

        // create an object of inner class RAM using outer class CPU
        InnerClass.RAM ram = cpu.new RAM();
        System.out.println("Processor Cache = " + processor.getCache());
        System.out.println("Ram Clock speed = " + ram.getClockSpeed());
    }
}
