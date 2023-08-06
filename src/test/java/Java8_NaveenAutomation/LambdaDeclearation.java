package Java8_NaveenAutomation;

public class LambdaDeclearation {
    public static void main(String[] args) {


        // annonimous class
        WebPage w1 = new WebPage() {
            @Override
            public void header(String value) {
                System.out.println("Hi "+value);

            }
        };
        w1.header("Google");
        // annonimous class

        WebPage w2 = (value -> System.out.println("Hi "+value));
        w2.header("Google");

    }
}
