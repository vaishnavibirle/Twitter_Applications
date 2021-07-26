package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp_Page extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'Sign up')]")
    WebElement signUp;

    @FindBy(css = "input[name='name']")
    WebElement Name;

    @FindBy(xpath = "//input[@name='phone_number']")
    WebElement Phone_No;

    @FindBy(id = "SELECTOR_1")
    WebElement Birthday_Month;

    @FindBy(id = "SELECTOR_2")
    WebElement Birthday_Date;

    @FindBy(id = "SELECTOR_3")
    WebElement Birthday_Year;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement NextBtn;

    @FindBy(xpath = "//span[contains(text(),'OK')]")
    WebElement OkBtn;

    public SignUp_Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String signup_with_credentials() throws InterruptedException {
        signUp.click();
        Thread.sleep(2000);
        Name.sendKeys("Harshal");
        Thread.sleep(1000);
        Phone_No.sendKeys("2243026816");
        Thread.sleep(2000);
        Birthday_Month.sendKeys("May");
        Birthday_Date.sendKeys("24");
        Birthday_Year.sendKeys("2004");
        Thread.sleep(2000);
        NextBtn.click();
        Thread.sleep(1000);
        NextBtn.click();
        Thread.sleep(1000);
        signUp.click();
        Thread.sleep(1000);
        OkBtn.click();
        Thread.sleep(1000);
        return driver.getTitle();
    }




}
