package com.qa.techtorialwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Products']")
    WebElement productsButton;

    @FindBy(xpath = "//a[@title='Clients']")
    WebElement clientsButton;

    public void clickProductButton(){
        productsButton.click();
    }
    public void clickClientsButton(){clientsButton.click();}
}
