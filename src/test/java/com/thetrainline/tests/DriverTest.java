package com.thetrainline.tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class DriverTest {


    protected static WebDriver driver;

    @BeforeTest
    public void openPage() {
        System.setProperty("webdriver.chrome.driver","src/test/res/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public static void tearDown() {
        driver.close();
    }

}
