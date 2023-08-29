package Java8ByProgRank;

public class ThreadExample implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<=10;i++)
        {
            System.out.println("Hello");
        }

    }

    public static void main(String[] args) {
        ThreadExample obj = new ThreadExample();
        Thread thread = new Thread(obj);
        thread.run();
        obj.run();

    }
}
