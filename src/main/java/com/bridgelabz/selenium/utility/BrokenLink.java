package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrokenLink extends BaseClass {

    @FindBy(tagName = "a")
    List<WebElement> link;

    @FindBy(tagName = "img")
    WebElement image;

    public BrokenLink(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String broken_link() throws IOException {
        List<WebElement> linkList = link;
        linkList.addAll(Collections.singleton(image));

        System.out.println("size of full links and images-->>"+linkList.size());

        List<WebElement> activeLinks = new ArrayList<WebElement>();

        for(int i=0;i<linkList.size();i++){
            System.out.println(linkList.get(i).getAttribute("href"));
            if(linkList.get(i).getAttribute("href") != null && (!linkList.get(i).getAttribute("href").contains("javascript")));
            {
                activeLinks.add(linkList.get(i));
            }
        }

        System.out.println("size of active links and images --->>"+activeLinks.size());

        for (int j=0;j<activeLinks.size();j++){
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href")+"-->>"+response);
        }
        return driver.getCurrentUrl();
    }
}
