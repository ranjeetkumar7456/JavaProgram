package JavaCode.constructor;

public class Constructor {
    private String name;

    // constructor
    Constructor() {
        System.out.println("Constructor Called:");
        name = "Programiz";
    }

    public static void main(String[] args) {

        // constructor is invoked while
        // creating an object of the Main class
        Constructor obj = new Constructor();
        System.out.println("The name is " + obj.name);
    }
}