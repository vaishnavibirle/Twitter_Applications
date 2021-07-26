package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;

import java.io.FileInputStream;
import java.util.Properties;

@Description("Library class for setting config_path")
@Story("created method getProperty and added parameter config_path and key" +
        "use try catch exception handling" +
        "return property")
@Severity(SeverityLevel.NORMAL)

public class Library extends BaseClass {

    public static String CONFIG_PATH = "config/config.properties";

    public static String getProperty(String CONFIG_PATH , String key){
        String property = "";
        Properties obj = new Properties();
        try {
            obj.load(new FileInputStream(CONFIG_PATH));
            property = obj.getProperty(key);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return property;
    }
}
