package com.buggy.car.portals.tests;

import com.buggy.car.portals.beans.LoginBean;
import com.buggy.car.portals.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Reporter;


@Test()
public class LoginTest extends BuggyTestSetup {

    private SoftAssert softAssert = new SoftAssert();
    WebDriver webDriver;
    LoginBean loginBean;
    LoginPage loginPage;



    private void setDefaultValues(){
        loginBean = new LoginBean();
        loginBean.setName("midhunjose");
        loginBean.setPassword("P@ssw0rd1");

    }

    @BeforeClass
    public void setUp(){
        webDriver = brew();
        loginPage = new LoginPage(webDriver);

    }

    @Test
    public void test_valid_login(){
        webDriver.get("https://buggy.justtestit.org/");

        setDefaultValues();
        loginPage.setWebLoginTxt(loginBean.getName());
        loginPage.setWebPasswordTxt(loginBean.getPassword());
        loginPage.clickWebLoginBtn();
        String expectedTitle = "Buggy Cars";
        String originalTitle = webDriver.getTitle();
        softAssert.assertEquals(originalTitle, expectedTitle);
        softAssert.assertEquals(originalTitle, "Buggy Cars Portal" );
        softAssert.assertTrue(loginPage.validateLoginGreeting("Midhun"), "Invalid login");
        softAssert.assertAll();
    }

    @Test
    public void test_invalid_password(){
        setDefaultValues();
        loginBean.setPassword("WrongPassword");
        loginPage.setWebLoginTxt(loginBean.getName());
        loginPage.setWebPasswordTxt(loginBean.getPassword());
        loginPage.clickWebLoginBtn();
        Assert.assertTrue(loginPage.validateInValidLogin("Invalid username/password"), "Invalid login");
    }
    @Test
    public void test_invalid_username(){
        setDefaultValues();
        loginBean.setName("WrongName");
        loginPage.setWebLoginTxt(loginBean.getName());
        loginPage.setWebPasswordTxt(loginBean.getPassword());
        loginPage.clickWebLoginBtn();
    }

    @Test
    public void test_blank_username(){
        setDefaultValues();
        loginBean.setName("");
        loginPage.setWebLoginTxt(loginBean.getName());
        loginPage.setWebPasswordTxt(loginBean.getPassword());
        loginPage.clickWebLoginBtn();
    }

    @AfterClass
    public void tearDown(){
        if (webDriver !=null) {
            webDriver.quit();
            Reporter.log("Driver Closed After Testing");
        }
    }
}
