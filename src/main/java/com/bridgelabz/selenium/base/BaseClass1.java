package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass1 {

    public static WebDriver driver;

    @BeforeTest
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        Log.info("Chrome browser is setting");
        driver = new ChromeDriver();
        Log.info("Chrome driver is launched");
        driver.get("https://static.collegedekho.com/media/django-summernote/2021-07-19/5f802b43-bc33-43f8-8881-3a9e0b0240b1.pdf");
    }

    @AfterTest
    public void tearDown(){
        Log.info("Browser is closed");
        driver.quit();
        Log.info("Test is ended");
        Reporter.log("====Application Launched====");
    }
}