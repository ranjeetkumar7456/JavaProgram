package MultiThreadingConceptNew;

public class MultiThreadExampleRunnable
{
    public static void main(String args[])
    {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();
    }
}
