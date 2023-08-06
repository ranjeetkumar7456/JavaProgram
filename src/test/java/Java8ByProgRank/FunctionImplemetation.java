package Java8ByProgRank;

public class FunctionImplemetation {
    public static void main(String[] args) {
        FunctionalInterfaceExample lambda = ()-> System.out.println("This is functional interface Example");
        lambda.display();
        lambda.show();
        FunctionalInterfaceExample.print();
        
    }
}
