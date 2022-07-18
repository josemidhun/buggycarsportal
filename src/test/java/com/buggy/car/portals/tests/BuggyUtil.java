package com.buggy.car.portals.tests;

import com.buggy.car.portals.beans.RegisterBean;
import com.buggy.car.portals.pages.LoginPage;
import com.buggy.car.portals.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

public class BuggyUtil {

    private LoginPage loginPage;
    private RegisterBean registerBean;
    private RegisterPage registerPage;

    private void setDefaultValues(){
        registerBean = new RegisterBean();
        String username = "skodarapid"+ Math.random();
        registerBean.setLogin(username);
        registerBean.setFirstName("Skoda");
        registerBean.setLastName("Rapid");
        registerBean.setPassword("P@ssw0rd1");
        registerBean.setConfirmPassword("P@ssw0rd1");
    }
    public void login(){
        loginPage.setWebLoginTxt(registerBean.getLogin());
        loginPage.setWebPasswordTxt(registerBean.getPassword());
        loginPage.clickWebLoginBtn();
    }
    public RegisterBean registerAndLogin(WebDriver driver){
        driver.get("https://buggy.justtestit.org/");

        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        setDefaultValues();
        loginPage.clickWebRegisterNavBtn();
        registerPage.setWebRegLoginTxt(registerBean.getLogin());
        registerPage.setWebRegFirstNameTxt(registerBean.getFirstName());
        registerPage.setWebRegLastNameTxt(registerBean.getLastName());
        registerPage.setWebRegPasswordTxt(registerBean.getPassword());
        registerPage.setWebRegConfirmPasswordTxt(registerBean.getConfirmPassword());
        registerPage.clickWebRegisterBtnSubmit();
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {}

        login();
        return registerBean;

    }

    public void buggySleep() {
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {}
    }
}
