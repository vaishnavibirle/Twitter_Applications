package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.utility.Log;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.FileNotFoundException;
import java.io.IOException;

@Description("Created HomePage class for performing search , post")
@Story("Finded the elements by using locators, Implemented Page Factory" +
        "Called Constructor and created method for" +
        "searching and posting " +
        "Also used autoIT for uploading file" +
        "Returned the title of the page")
@Severity(SeverityLevel.NORMAL)

public class HomePage extends BaseClass {

    @FindBy(xpath = "//input[@placeholder='Search Twitter']")
    WebElement search_bar;

    @FindBy(xpath = "//div[@aria-label='Add photos or video']//div[@class='css-901oao r-1awozwy r-13gxpu9 r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']//*[local-name()='svg']")
    WebElement addphoto;

    @FindBy(xpath = "//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'][normalize-space()='Tweet']")
    WebElement tweet;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String search_Text() throws InterruptedException {
        Actions actions = new Actions (driver);
        Log.info("Sending brillio input in search bar");
        actions.sendKeys(search_bar,"brillio").build().perform();
        Log.info("Clicking on option");
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        Log.info("Returning title of the page");
        return driver.getTitle();
    }

    public String post_photo() throws InterruptedException, IOException {
        addphoto.click();
        Thread.sleep(1000);
        autoIT();
        tweet.click();
        Thread.sleep(3000);
        return driver.getTitle();
    }

    private void autoIT() throws IOException {
        try {
            Runtime.getRuntime().exec("C:\\Users\\irg\\OneDrive\\Desktop\\AutoIT\\Upload_Photo.exe");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}


