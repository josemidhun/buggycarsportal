package com.buggy.car.portals.tests;

import com.buggy.car.portals.beans.RegisterBean;
import com.buggy.car.portals.pages.LoginPage;
import com.buggy.car.portals.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest extends BuggyTestSetup {

    WebDriver driver;
    LoginPage loginPage;
    RegisterBean registerBean;
    RegisterPage registerPage;

    private void setDefaultValues(){
        registerBean = new RegisterBean();
        registerBean.setLogin("skodarapid"+ Math.random());
        registerBean.setFirstName("Skoda");
        registerBean.setLastName("Rapid");
        registerBean.setPassword("P@ssw0rd1");
        registerBean.setConfirmPassword("P@ssw0rd1");
    }

    @BeforeClass
    public void setUp(){
        driver = brew();
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void test_valid_register(){
        driver.get("https://buggy.justtestit.org/");
        setDefaultValues();
        loginPage.clickWebRegisterNavBtn();
        registerPage.setWebRegLoginTxt(registerBean.getLogin());
        registerPage.setWebRegFirstNameTxt(registerBean.getFirstName());
        registerPage.setWebRegLastNameTxt(registerBean.getLastName());
        registerPage.setWebRegPasswordTxt(registerBean.getPassword());
        registerPage.setWebRegConfirmPasswordTxt(registerBean.getConfirmPassword());
        registerPage.clickWebRegisterBtnSubmit();
        Assert.assertTrue(registerPage.validateValidRegister("Registration is successful"), "Register Failed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
