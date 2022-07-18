package com.buggy.car.portals.tests;

import com.buggy.car.portals.pages.BuggyCarsVotePage;
import com.buggy.car.portals.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BuggyCarsVoteTest extends BuggyTestSetup {
    WebDriver driver;
    LoginPage loginPage;
    BuggyCarsVotePage buggyCarsVotePage;



    @BeforeClass
    public void setUp(){
        driver = brew();
        loginPage = new LoginPage(driver);
        buggyCarsVotePage = new BuggyCarsVotePage(driver);
    }

    @Test
    public void test_voting(){
        BuggyUtil buggyUtil = new BuggyUtil();
        buggyUtil.registerAndLogin(driver);

        buggyCarsVotePage.clickWebBuggyRatingBtn();
        buggyCarsVotePage.clickWebAllCarModelsImage();
        buggyCarsVotePage.clickWebViewMoreLink();
        String currentVoteCount = buggyCarsVotePage.getWebVotesCount().getText();
        buggyUtil.buggySleep();
        buggyCarsVotePage.setWebComments("Recent Vote" + currentVoteCount);
        buggyUtil.buggySleep();
        buggyCarsVotePage.clickWebVoteBtn();
        buggyUtil.buggySleep();
        String newVoteCount = buggyCarsVotePage.getWebVotesCount().getText();
        System.out.println(currentVoteCount);
        System.out.println(newVoteCount);
        Assert.assertTrue(Integer.parseInt(currentVoteCount)+1 == Integer.parseInt(newVoteCount));
    }
    @AfterClass
    public void tearDown(){
        if (driver !=null) {
            driver.quit();
        }
    }

}
