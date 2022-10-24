package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase // By this we make all the classes as a child class of 'TestBase'.
{
    // Page Factory- Object Repository (OR)

    // We will find the element from the Login page, what is the first thing we have to do, we will have to
    // fill the username and password. That's why we will go the page and find the selector. The command is like:


    //PageFactory:

    @FindBy(name= "username")
    WebElement username;

    @FindBy(name ="password")
    WebElement password;

    @FindBy(xpath = "//input[@type= 'submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement singnUpBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement crmlogo;

    // After then, we have to initialize these methods by creating a constructor with the help of PageFactory.

    //Initializing the page Object
    public LoginPage()
    {
        PageFactory.initElements(driver, this); // driver is coming from Login page, so, we have to make the driver as public.
        // this means all elements of this page. 'this' is pointing to the current class (LoginPage) object.

    }

    // After that we have to create method for functionality of these elements,here:

    //ACTIONS:
    public String validateloginpageTitle()
    {
        return driver.getTitle();
    }
    public boolean validateCRMLogo()
    {
        return crmlogo.isDisplayed();
    }
    public HomePage login(String un, String pwd)
    {
        username.sendKeys();
        password.sendKeys();
        loginBtn.click();

        // instead of void we will make 'HomePage' return type by replacing void to HomePage.
        return new HomePage();
    }

}
