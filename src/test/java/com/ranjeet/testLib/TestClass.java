package com.ranjeet.testLib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
