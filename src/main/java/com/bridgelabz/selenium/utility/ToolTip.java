package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTip extends BaseClass {

    @FindBy(xpath = "//a[@aria-label='Home']")
    WebElement home;

    public ToolTip(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String tool_tip() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(home).build().perform();
        String toolTip = home.getAttribute("aria-label");
        System.out.println("ToolTip is: " + toolTip);
        return toolTip;
    }
}

