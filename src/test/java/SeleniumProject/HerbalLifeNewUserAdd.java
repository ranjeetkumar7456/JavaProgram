package SeleniumProject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HerbalLifeNewUserAdd {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\driver1\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setBrowserVersion("120");
        WebDriver driver = new ChromeDriver(option);
        //Maximize the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.myherbalife.com/");
        WebElement memberLogin = driver.findElement(By.xpath("//a[@id='MemberLoginLink']"));
        memberLogin.click();
        WebElement applyOnline= driver.findElement(By.xpath("//a[normalize-space()='Apply Online']"));
        applyOnline.click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        WebElement iMNotRobot= driver.findElement(By.xpath("//div[@id='rc-anchor-container']"));
        iMNotRobot.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement createAccountBtn = driver.findElement(By.xpath("//a[@id='create-account']"));
        createAccountBtn.click();



        Thread.sleep(5000);
        //driver.close();





    }


    public static void readExcelData() throws IOException {
        //Path of the excel file
        FileInputStream fs = new FileInputStream("C:\\Users\\HP\\Desktop\\data.xlsx");
//Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(sheet.getRow(0).getCell(0));
        Row row1 = sheet.getRow(1);
        Cell cell1 = row1.getCell(1);
        System.out.println(sheet.getRow(0).getCell(1));
        Row row2 = sheet.getRow(1);
        Cell cell2 = row2.getCell(1);
        System.out.println(sheet.getRow(1).getCell(0));
        Row row3 = sheet.getRow(1);
        Cell cell3 = row3.getCell(1);
        System.out.println(sheet.getRow(1).getCell(1));
//String cellval = cell.getStringCellValue();
//System.out.println(cellval);




    }


}
