package Kaplan;

import org.testng.annotations.*;

public class Demo
{
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before suite");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("After suite");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("After class");
    }

    @BeforeMethod
    public void beforemethod()
    {
        System.out.println("Before method");
    }

    @AfterMethod
    public void aftermethod()
    {
        System.out.println("After method");
    }


    @Test
    public void test1()
    {
        System.out.println("Test case is executed");
    }

    @Test
    public void test2()
    {
        System.out.println("Test case is executed");
    }

    @Test
    public void test3()
    {
        System.out.println("Test case is executed");
    }

    @Test
    public void test4()
    {
        System.out.println("Test case is executed");
    }

}
