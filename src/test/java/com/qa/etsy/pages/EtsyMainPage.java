package com.qa.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyMainPage {

    public EtsyMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#global-enhancements-search-query")
    WebElement searchBar;

    public void searchItem(String item){
        searchBar.sendKeys(item, Keys.ENTER);
    }
}
