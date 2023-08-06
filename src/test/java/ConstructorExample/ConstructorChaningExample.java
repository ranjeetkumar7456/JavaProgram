package ConstructorExample;

public class ConstructorChaningExample
{
    private int property1;
    private String property2;
    private double property3;

    public ConstructorChaningExample(int property11, String property22, double property33)
    {
        this.property1 = property11;
        this.property2 = property22;
        this.property3 = property33;
    }

    public ConstructorChaningExample(int property111, String property222)
    {
        this(property111,property222,0.0);

    }

    public ConstructorChaningExample(int property1111)
    {
        this(property1111,"Default");
    }
    public ConstructorChaningExample()
    {
        this(0);
    }


    // Getters and Setters for the properties
    public int getProperty1() {
        return property1;
    }

    public void setProperty1(int property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public double getProperty3() {
        return property3;
    }

    public void setProperty3(double property3) {
        this.property3 = property3;
    }

    public static void main(String[] args)
    {
        ConstructorChaningExample obj1 = new ConstructorChaningExample();
        ConstructorChaningExample obj2 = new ConstructorChaningExample(10);
        ConstructorChaningExample obj3 = new ConstructorChaningExample(20, "CustomName");
        ConstructorChaningExample obj4 = new ConstructorChaningExample(30, "CustomName", 3.14);

        // Print the properties of each object
        System.out.println("Object 1 - property1: " + obj1.getProperty1() + ", property2: " + obj1.getProperty2() + ", property3: " + obj1.getProperty3());
        System.out.println("Object 2 - property1: " + obj2.getProperty1() + ", property2: " + obj2.getProperty2() + ", property3: " + obj2.getProperty3());
        System.out.println("Object 3 - property1: " + obj3.getProperty1() + ", property2: " + obj3.getProperty2() + ", property3: " + obj3.getProperty3());
        System.out.println("Object 4 - property1: " + obj4.getProperty1() + ", property2: " + obj4.getProperty2() + ", property3: " + obj4.getProperty3());

    }
}
