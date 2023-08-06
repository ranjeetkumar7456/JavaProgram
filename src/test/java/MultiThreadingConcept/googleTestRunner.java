package MultiThreadingConcept;

public class googleTestRunner {

    public static void main(String[] args) {
      Thread t1 =   new GoogleFeatureThread("chrome thread","chrome");
        Thread t2 =   new GoogleFeatureThread("firefox thread","firefox");
        System.out.println("Thread is started .........");
        t1.start();
        t2.start();

        System.out.println("Threas is stopped .........");

    }
}
