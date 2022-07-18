package com.buggy.car.portals.tests;
import com.buggy.car.portals.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class ParameterCrossBrowserTest {


    //WebDriverManager is an open-source Java library
    //that carries out the management (i.e., download, setup, and maintenance)
    //of the drivers required by Selenium WebDriver (e.g., chromedriver, geckodriver, msedgedriver, etc.)
    //in a fully automated manner.
    //In addition, WebDriverManager provides other relevant features,
    //such as the capability to discover browsers installed in the local system,
    //building WebDriver objects (such as ChromeDriver, FirefoxDriver, EdgeDriver, etc.),

    LoginPage loginPage;
    WebDriver driver;


    private void LoginCall(){

        loginPage = new LoginPage(driver);
        loginPage.setWebLoginTxt("midhunjose");
        loginPage.setWebPasswordTxt("P@ssw0rd1");
        loginPage.clickWebLoginBtn();
    }

    private void chromeSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://buggy.justtestit.org/");

        LoginCall();

        //Soft Assert - Verify
        //Test execution will continue till the end of the test case even if assert condition is not met
        //To view assertions result at the end of the test, tester has to invoke assertAll()

        SoftAssert softAssert = new SoftAssert();
        String getActualTitle = driver.getTitle();
        Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Buggy Cars Rating");
        softAssert.assertEquals(getActualTitle, "Buggy Cars Rating");
        softAssert.assertNotEquals(getActualTitle, "Buggy Cars Rating");
        softAssert.assertNull(verifyTitle);
        softAssert.assertNotNull(verifyTitle);
        softAssert.assertTrue("Expected Title".equals("Buggy Cars Rating"), "First soft assert failed");
        softAssert.assertFalse("Buggy Cars Rating".equals("Buggy Cars Rating"), "Second soft assert failed");
        softAssert.assertAll();

        System.out.println("chromeSession completed");
        driver.quit();
    }

    private void edgeSession() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.navigate().to("https://buggy.justtestit.org/");


        LoginCall();

        //Hard Assert
        // Test Execution will be aborted if assert condition is not met
        // Does not have to invoke any methods to capture the assertions
        String ActualTitle = driver.getTitle();
        String verifyAssertNull=null;
        String ExpectedTitle = "Buggy Cars Rating";
        Boolean verifyTitleIsPresent=driver.getTitle().equalsIgnoreCase("Cross Browser Testing");
        Boolean verifyTitleIsChanged=driver.getTitle().equalsIgnoreCase("Buggy Cars Rating");
        assertEquals(ExpectedTitle, ActualTitle);
        assertNotEquals(ExpectedTitle, "Buggy Cars Rating");
        assertTrue(verifyTitleIsPresent);
        assertFalse(verifyTitleIsChanged);
        assertNotNull(verifyTitleIsPresent);
        assertNull(verifyAssertNull);

        System.out.println("edgeSession completed");
        String title = driver.getTitle();
        System.out.println("Title = " + title);
        driver.quit();
    }

    @Test
   @Parameters("browser")
    public void crossBrowserTest(String browser){

        if(browser.equals("chrome")){
            System.out.println("call ----- chromeSession");
            chromeSession();
        } else if (browser.equals("edge")) {
            System.out.println("call ----- edgeSession");
            edgeSession();
        }
    }
/*
    @Test
    public void ParameterCrossBrowserTest(){
        //crossBrowserTest("chrome");
        //crossBrowserTest("edge");
    }
*/



}
