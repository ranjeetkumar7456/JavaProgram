package Java8ByProgRank;


@FunctionalInterface
public interface FunctionalInterfaceExample {


    void show();

    static void print()
    {
        System.out.println("I am static method");
    }
    default void display()
    {
        System.out.println("I am default method");
    }
}
