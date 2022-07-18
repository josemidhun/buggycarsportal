package com.buggy.car.portals.tests;

import com.buggy.car.portals.beans.LoginBean;
import com.buggy.car.portals.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Test()
public class ParameterLoginTest extends BuggyTestSetup {

    private SoftAssert softAssert = new SoftAssert();
    WebDriver driver;
    LoginPage loginPage;


    @BeforeClass
    public void setUp(){
        driver = brew();
        loginPage = new LoginPage(driver);

    }
    @Parameters({"username","password","users"})
    @Test
    public void test_valid_login(String username,String password, String users){

        //users = username1,password1 username2,password2 username3,password3
        String [] userlist = users.split(" ");
        //userlist [0] = username1,password1
        //userlist [1] = username2,password2
        for (String user:userlist){
            //user = username1,password1........username2,password2
            String [] usernamepassword = user.split(",");
            //usernamepassword [0] = username1.....username2
            //usernamepassword [1] = password1.....password2
            test_parameter_login(usernamepassword[0],usernamepassword[1]);
           Reporter.log(usernamepassword[0] + usernamepassword[1]);

        }

    }

    private void test_parameter_login(String username, String password){

        driver.navigate().to("https://buggy.justtestit.org/");
        loginPage.setWebLoginTxt(username);
        loginPage.setWebPasswordTxt(password);
        loginPage.clickWebLoginBtn();

        softAssert.assertTrue(loginPage.validateInValidLogin("Invalid username/password"), "Invalid login");
        Reporter.log("Login Failure");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){
        if (driver !=null) {
            driver.quit();
            Reporter.log("Driver Closed After Testing");
        }
    }
}
