package com.buggy.car.portals.tests;

import com.buggy.car.portals.pages.LoginPage;
import com.buggy.car.portals.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTest extends BuggyTestSetup {

    WebDriver driver;
    LoginPage loginPage;

    LogoutPage logoutPage;

    @BeforeClass
    public void setUp() {
        driver = brew();
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @Test
    public void test_voting(){
        BuggyUtil buggyUtil = new BuggyUtil();
        buggyUtil.registerAndLogin(driver);
        logoutPage.clickWebProfileLnk();
        buggyUtil.buggySleep();
        logoutPage.clickWebLogoutLnk();
    }
    @AfterClass
    public void tearDown(){
        if (driver !=null) {
            driver.quit();
        }
    }

}
