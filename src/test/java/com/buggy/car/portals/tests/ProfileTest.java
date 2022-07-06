package com.buggy.car.portals.tests;

import com.buggy.car.portals.pages.LoginPage;
import com.buggy.car.portals.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTest extends BuggyTestSetup {

    WebDriver webDriver;
    LoginPage loginPage;

    LogoutPage logoutPage;

    @BeforeClass
    public void setUp() {
        webDriver = brew();
        loginPage = new LoginPage(webDriver);
        logoutPage = new LogoutPage(webDriver);
    }

    @Test
    public void test_voting(){
        BuggyUtil buggyUtil = new BuggyUtil();
        buggyUtil.registerAndLogin(webDriver);
        logoutPage.clickWebProfileLnk();
        buggyUtil.buggySleep();
        logoutPage.clickWebLogoutLnk();
    }
    @AfterClass
    public void tearDown(){
        if (webDriver !=null) {
            webDriver.quit();
        }
    }

}
