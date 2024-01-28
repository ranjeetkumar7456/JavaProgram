package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitComponent
{
        public WebDriver driver;
        public Duration timeout;
        public Duration pollFrequency;

        public FluentWaitComponent(WebDriver driver, Duration timeout, Duration pollFrequency) {
            this.driver = driver;
            this.timeout = timeout;
            this.pollFrequency = pollFrequency;
        }

        public WebElement waitForElement(By by)
        {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(timeout)
                    .pollingEvery(pollFrequency)
                    .ignoring(Exception.class);

            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }

        public static void performAction()
        {

        }

        public void performActionOnElement(WebElement element, Action action) {
            if (element != null) {
                try {
                    action.perform(element);
                } catch (Exception e) {
                    System.out.println("An error occurred while performing the action: " + e.getMessage());
                }
            } else {
                System.out.println("Element is null. Cannot perform action.");
            }
        }

        // Define a functional interface for actions on elements
        @FunctionalInterface
        public interface Action {
            void perform(WebElement element);
        }
    }


