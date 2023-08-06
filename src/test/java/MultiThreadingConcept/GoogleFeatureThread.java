package MultiThreadingConcept;

public class GoogleFeatureThread extends Thread{

    public String browserName;
    google googlePage;

    public GoogleFeatureThread(String threadName,String browserName)
    {
        super(threadName);
        this.browserName = browserName;
        googlePage = new google();
    }

    @Override
    public void run()
    {
        System.out.println("Thread  -- Started "+Thread.currentThread().getName());
        try
        {
            Thread.sleep(1000);
            googlePage.setUp(this.browserName);
            googlePage.googleSearch();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            googlePage.tearDown();
        }
    }
}
