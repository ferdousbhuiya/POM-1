package com.crm.qa.testdata;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase // this test file also the extends of TestBase file.
{
    LoginPage  logInPage;
    HomePage homePage;
// First of all we have to make one constructor of LoginPageTest:
    public LoginPageTest()
    {
         // super is used here for "To call the parent class constructor. That is available in line no. 19 of
        //TestBase.java, this is like 'public TestBase()' .

        super();
    }
    // we have remember the sequence of Methods as like:

    // We have to initialize the constructor
   // @BeforeMethod
   // public void setup()
    //{
    //    initialization(); // it is calling the method named "initialization()" at class name 'TestBase' at line no. 40
        LoginPage loginPage = new LoginPage(); // create the object of LogInPage.
   // }

    @Test(priority = 1)
    public void loginPageTitleTest()
    {
        String title = logInPage.validateloginpageTitle();
        Assert.assertEquals(title, "Free CRM  - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority = 2)
            public void crmLogoImage()
    {
        boolean flag = logInPage.validateCRMLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest()
    {
        homePage = logInPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    //@AfterMethod
   // public void tearDown()
   // {
   //     driver.quit();
   // }
}
