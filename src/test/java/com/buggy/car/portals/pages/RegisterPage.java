package com.buggy.car.portals.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/my-app/div/main/my-register/div/div/form/div[1]/input")
    WebElement webRegLoginTxt;

    @FindBy(xpath = "/html/body/my-app/div/main/my-register/div/div/form/div[2]/input")
    WebElement webRegFirstNameTxt;

    @FindBy(xpath = "/html/body/my-app/div/main/my-register/div/div/form/div[3]/input")
    WebElement webRegLastNameTxt;

    @FindBy(xpath = "/html/body/my-app/div/main/my-register/div/div/form/div[4]/input")
    WebElement webRegPasswordTxt;

    @FindBy(xpath = "/html/body/my-app/div/main/my-register/div/div/form/div[5]/input")
    WebElement webRegConfirmPasswordTxt;


    @FindBy(xpath ="//button[text()='Register']")
    WebElement webRegSubBtn;

    @FindBy(xpath = "/html/body/my-app/div/main/my-register/div/div/form/div[6]")
    WebElement webRegSuccessMessage;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setWebRegLoginTxt(String webRegLoginTxt) {
        this.webRegLoginTxt.clear();
        this.webRegLoginTxt.sendKeys(webRegLoginTxt);
    }

    public void setWebRegFirstNameTxt(String webRegFirstNameTxt) {
        this.webRegFirstNameTxt.clear();
        this.webRegFirstNameTxt.sendKeys(webRegFirstNameTxt);

    }

    public void setWebRegLastNameTxt(String webRegLastNameTxt) {
        this.webRegLastNameTxt.clear();
        this.webRegLastNameTxt.sendKeys(webRegLastNameTxt);

    }

    public void setWebRegPasswordTxt(String webRegPasswordTxt) {
        this.webRegPasswordTxt.clear();
        this.webRegPasswordTxt.sendKeys(webRegPasswordTxt);

    }

    public void setWebRegConfirmPasswordTxt(String webRegConfirmPasswordTxt) {
        this.webRegConfirmPasswordTxt.clear();
        this.webRegConfirmPasswordTxt.sendKeys(webRegConfirmPasswordTxt);

    }

    public void clickWebRegisterBtnSubmit(){
        this.webRegSubBtn.click();
    }

    public boolean validateValidRegister(String successMessage) {
        if(webRegSuccessMessage.getText().contains(successMessage))
            return true;

        return false;
    }
}
