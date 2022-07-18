package com.buggy.car.portals.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuggyCarsVotePage {

    private WebDriver driver;


    @FindBy(xpath = "/html/body/my-app/div/main/my-home/div/div[3]/div/a/img")
    WebElement webAllCarModelsImage;

    @FindBy(xpath = "/html/body/my-app/div/main/my-overall/div/div/table/tbody/tr[3]/td[7]/a")
    WebElement webViewMoreLink;

    @FindBy(xpath = "/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[1]/h4/strong")
    WebElement webVotesCount;

    @FindBy(xpath = "/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/fieldset/textarea")
    WebElement webComments;

    @FindBy(xpath = "/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/div/button")
    WebElement webVoteBtn;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/a")
    WebElement webBuggyRatingBtn;


    public BuggyCarsVotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setWebComments(String webComments) {
        this.webComments.clear();
        this.webComments.sendKeys(webComments);
    }

    public WebElement getWebVotesCount() {
        return webVotesCount;
    }

    public void clickWebBuggyRatingBtn(){
        this.webBuggyRatingBtn.click();
    }

    public void clickWebAllCarModelsImage(){
        this.webAllCarModelsImage.click();
    }

    public void clickWebViewMoreLink(){this.webViewMoreLink.click();}

    public void clickWebVoteBtn(){this.webVoteBtn.click();}
}
