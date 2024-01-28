package MultiThreadingConceptNew;

public class Multithread1
{
    public static void main(String[] args)
    {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++)
        {
            Thread object = new Thread(new MultithreadingDemo1());
            object.start();
        }
    }
}
