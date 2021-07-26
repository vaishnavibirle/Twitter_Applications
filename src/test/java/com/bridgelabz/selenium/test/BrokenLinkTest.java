package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.utility.BrokenLink;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrokenLinkTest extends BaseClass {

    @Test(priority = 7)
    public void brokenLink() throws IOException {
        BrokenLink brokenLink = new BrokenLink(driver);
        String actual = brokenLink.broken_link();
        String expected = "https://twitter.com/";
        Assert.assertEquals(actual,expected);
        System.out.println("Broken links have been founded successfully!");

    }
}
