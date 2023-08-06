package Kaplan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class ParallelExecutionExample {

    private WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            // Set the path to the Chrome driver executable
            System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\src\\test\\java\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Set the path to the Gecko driver executable
            System.setProperty("webdriver.gecko.driver", "D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\src\\test\\java\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            // Set the path to the Edge driver executable
            System.setProperty("webdriver.edge.driver", "D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\src\\test\\java\\driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
    }

    @Test(threadPoolSize = 3, invocationCount = 6)
    @Parameters("browser")
    public void testMethod(String browser) {
        driver.get("https://www.example.com");

        // Add your test steps and assertions

        // Example: Find an element and perform an action
        driver.findElement(By.id("elementId")).click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

