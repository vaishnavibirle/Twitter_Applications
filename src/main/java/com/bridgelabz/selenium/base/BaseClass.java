package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.utility.EmailReport;
import com.bridgelabz.selenium.utility.Library;
import com.bridgelabz.selenium.utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public static WebDriver driver;

    @BeforeTest
    @Feature("BrowserName and url for starting test")
    @Description("Used setUp method for setting the browser")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Navigating to url : https://www.linkedin.com")
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        Log.info("Test is starting");
        Log.info("chrome is starting");
        driver = new ChromeDriver();
        Log.info("navigating to url : https://www.twitter.com/");
        String url = Library.getProperty(Library.CONFIG_PATH,"URL");
        driver.get(url);
        driver.manage().window().maximize();
        Log.info("Launched the web application.");
        Thread.sleep(5000);
    }

    @AfterTest
    @Feature("Closing application")
    @Description("Used tearDown method for closing the browser.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Closing the browser.")
    public void tearDown() {
        EmailReport.sendMail();
        Log.info("Browser is closed");
        driver.quit();
        Log.info("Test is ended");
        Reporter.log("====Application Launched====");
    }
}
