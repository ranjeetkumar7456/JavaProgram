package StringProblems;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class testSet {
    public static void main(String[] args) {

        WebDriver driver =new ChromeDriver();


        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();






















        Set<String> hash_Set = new HashSet<String>();

        // Adding elements to the Set
        // using add() method
        String MainWindow = "For";
        hash_Set.add("Geeks");
        hash_Set.add("For");
        hash_Set.add("Geeks");
        hash_Set.add("Example");
        hash_Set.add("Set");


        //Set<String> s1 = driver.getWindowHandles();
        //System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = hash_Set.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                //String pageTitle=driver.getTitle();
                //System.out.println("The web page title of child window is:"+pageTitle);
                //driver.close();
                System.out.println("Child window closed");

                // Printing elements of HashSet object
                System.out.println(hash_Set);
            }
        }
    }
}