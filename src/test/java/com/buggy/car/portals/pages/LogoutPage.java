package com.buggy.car.portals.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage  {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/ul/li[2]/a")
    WebElement webProfileLnk;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/ul/li[3]/a")
    WebElement webLogoutLnk;


    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWebProfileLnk(){
        this.webProfileLnk.click();
    }
    public void clickWebLogoutLnk(){
        this.webLogoutLnk.click();
    }
}
