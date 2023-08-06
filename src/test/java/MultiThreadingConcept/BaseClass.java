package MultiThreadingConcept;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;

    //init
    public WebDriver setUp(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\src\\test\\java\\exeFile\\chromedriver.exe");
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\src\\test\\java\\exeFile\\geckodriver.exe");
        }
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

}
