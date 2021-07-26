package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.HomePage;
import com.bridgelabz.selenium.pages.Login;
import com.bridgelabz.selenium.pages.SignUp_Page;
import com.bridgelabz.selenium.utility.Log;
import com.bridgelabz.selenium.utility.MyScreenRecorder;
import com.bridgelabz.selenium.utility.ToolTip;
import com.bridgelabz.selenium.utility.listeners.CustomListener;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Description("Created test class for logging in" +
        "for searching anything" +
        "for posting / uploading a file")
@Story("Created twitter test class" +
        "called login_with_credentials method ," +
        "called search_text method" +
        "called post_photo method" +
        "called myscreenrecorder class for recording script execution.")
@Severity(SeverityLevel.MINOR)

@Listeners(CustomListener.class)
public class Twitter_Test extends BaseClass {

    @Test(priority = 1)
    public void login() throws Exception {
        MyScreenRecorder.startRecording("login");
        Log.info("Login Test is started");
        Login login = new Login(driver);
        Log.info("Providing actual title");
        String actual_Title = login.login_with_credentials();
        Log.info("Getting expected title");
        String expected_Title = "(1) Home / Twitter";
        Log.info("Comparing actual and expected title");
        Assert.assertEquals(actual_Title,expected_Title);
        Log.info("printing message  of successfully logged in");
        System.out.println("You are successfully Logged in..!!");
        MyScreenRecorder.stopRecording();
    }

    @Test(priority = 2)
    public void search() throws Exception {
        MyScreenRecorder.startRecording("search");
        Login login = new Login(driver);
        login.login_with_credentials();
        Log.info("Home page testing is started");
        HomePage homePage = new HomePage(driver);
        String actual_title = homePage.search_Text();
        String expected_title = "brillio - Twitter Search / Twitter";
        Assert.assertEquals(actual_title,expected_title);
        System.out.println("Your search result is there.");
        MyScreenRecorder.stopRecording();
        Log.info("Home Page search test is ended");
        MyScreenRecorder.stopRecording();
    }

    @Test(priority = 3)
    public void share_post() throws Exception {
        MyScreenRecorder.startRecording("share_post");
        Login login = new Login(driver);
        login.login_with_credentials();
        Log.info("Home page testing is started");
        HomePage homePage = new HomePage(driver);
        String actual_title = homePage.post_photo();
        String expected_title = "Home / Twitter";
        Assert.assertEquals(actual_title,expected_title);
        System.out.println("Your search result is there.");
        MyScreenRecorder.stopRecording();
        Log.info("Home Page search test is ended");
        MyScreenRecorder.stopRecording();
    }

    @Test(priority = 4)
    public void signup_Test() throws InterruptedException {
        SignUp_Page signUp_page = new SignUp_Page(driver);
        String actual = signUp_page.signup_with_credentials();
        String expected ="Sign up for Twitter / Twitter";
        Assert.assertEquals(actual,expected);
        System.out.println("Signup is done");
    }

    @Test(priority = 5)
    public void tool_tip_test() throws InterruptedException {
        Login login = new Login(driver);
        login.login_with_credentials();
        ToolTip toolTip = new ToolTip(driver);
        String actual_title = toolTip.tool_tip();
        String expected_title = "(1) Home / Twitter";
        Assert.assertEquals(actual_title,expected_title);
        System.out.println("Tool tip is: "+toolTip);
    }


}
