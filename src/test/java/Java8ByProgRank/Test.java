package Java8ByProgRank;

public class Test implements Anonymous{
    @Override
    public void show() {
        System.out.println("Hello coder");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.show();
        Anonymous lambda = () -> System.out.println("Hi Anonymous");
        lambda.show();
    }
}
