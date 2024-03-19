package com.qa.techtorialwork.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[.='Log In']")
    WebElement loginHeader;

    @FindBy(css = "#email")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@id='submit-login']")
    WebElement loginButton;
    @FindBy(css = ".invalid-feedback")
    WebElement errorMessage;
    public boolean loginHeaderDisplayed(){
        return loginHeader.isDisplayed();
    }

    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void validateMessageAndColor(String expectedMessage,String expectedColor){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(errorMessage));
        Assert.assertEquals(expectedColor,errorMessage.getCssValue("color"));
    }


}
