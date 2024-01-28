package MultiThreadingConceptNew;

public class MultiThreadExample {
    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        t1.start();  // This will invoke the run method in a separate thread

        MyThread t2 = new MyThread();
        t2.start();  // This will invoke the run method in another separate thread
    }
}
