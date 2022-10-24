package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{
   public static WebDriver driver; // initialize the webdriver
    public static Properties prop; // create one 'Properties' variable. it is global variable so, we can use everywhere.

    public TestBase() // constructor of the class
    {
        try
        {
            prop = new Properties(); //initialize the prop variable
            FileInputStream ip =
            new FileInputStream("/Users/ferdous/Desktop/QA online course in NY/Selenium_From_Class/POM-1/src/main/java/com/crm/qa/config/config.properties");
             //new FileInputStream(System.getProperty("src/Driver/chromedriver"));
            prop.load(ip);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initialization()// creating a method to inialilize a Driver, it will read from the Property file.

    {
        String browserName = prop.getProperty("browser"); // it will get the browser name from the property file.
        if(browserName.equals("chrome"))
        {
            driver=null;
            System.setProperty("webdriver.chrome.driver", "/Users/ferdous/Desktop/QA online course in NY/Selenium/Selenium/Driver/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browserName.equals("FF"))
        {
            System.setProperty("webdriver.gecko.driver", "src/Driver/geckodriver");
            driver = new FirefoxDriver();
        }

        //driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts();
driver.get("https://classic.crmpro.com/index.html");
        //driver.get(prop.getProperty("url")); // it will collect url from the property file.
    }


}
