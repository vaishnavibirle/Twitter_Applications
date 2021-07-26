package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.utility.Library;
import com.bridgelabz.selenium.utility.Log;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Description("Created Login class for performing login with credentials")
@Story("Finded the elements by using locators, Implemented Page Factory" +
        "Called Constructor and created method for logging in" +
        "Returned the title of the page")
@Severity(SeverityLevel.CRITICAL)

public class Login extends BaseClass {

    @FindBy(linkText = "Log in")
    WebElement login_btn;

    @FindBy(name = "session[username_or_email]")
    WebElement username;

    @FindBy(name = "session[password]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div")
    WebElement login;


    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String login_with_credentials() throws InterruptedException {
        Log.info("clicking on login button");
        login_btn.click();
        Thread.sleep(3000);
        Log.info("Entering email id ");
        username.sendKeys(Library.getProperty(Library.CONFIG_PATH,"email_id"));
        Log.info("Entering password");
        password.sendKeys(Library.getProperty(Library.CONFIG_PATH,"password_input"));
        Thread.sleep(3000);
        Log.info("Clicking on login after entering credentials");
        login.click();
        Thread.sleep(3000);
        Log.info("Returning title of the page");
        return driver.getTitle();
    }

}
