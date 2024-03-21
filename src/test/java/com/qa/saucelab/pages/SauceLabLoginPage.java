package com.qa.saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabLoginPage {

    public SauceLabLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;

    public void login(String username,String password) throws InterruptedException {
        this.username.sendKeys(username);
        Thread.sleep(1000);
        this.password.sendKeys(password);
        Thread.sleep(1000);
        loginButton.click();
    }

}
