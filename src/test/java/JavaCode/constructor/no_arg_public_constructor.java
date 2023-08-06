package JavaCode.constructor;




public class no_arg_public_constructor {
    String name;

    // public constructor
    public no_arg_public_constructor() {
        name = "Programiz";
    }
}

class Main {
    public static void main(String[] args) {

        // object is created in another class
        no_arg_public_constructor obj = new no_arg_public_constructor();
        System.out.println("Company name = " + obj.name);
    }
}