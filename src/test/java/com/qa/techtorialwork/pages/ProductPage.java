package com.qa.techtorialwork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ProductPage {

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='table-actions']//a")
    WebElement addProductButton;
    @FindBy(css = "#name")
    WebElement productName;
    @FindBy(css = "#price")
    WebElement productPrice;
    @FindBy(xpath = "//select[@id='product_category_id']")
    WebElement productCategory;
    @FindBy(xpath = "//select[@id='sub_category_id']")
    WebElement subCategory;
    @FindBy(xpath = "//select[@id='tax_id']")
    WebElement taxBox;
    @FindBy(css = "#purchase_allow")
    WebElement purchaseBox;
    @FindBy(css = "#description-text")
    WebElement description;
    @FindBy(xpath = "//button[@id='save-product']")
    WebElement saveButton;
    public void clickAddProductButton(){
        addProductButton.click();
    }

    public void productNameAndPrice(String productName,String productPrice) throws InterruptedException {
        this.productName.sendKeys(productName);
        Thread.sleep(2000);
        this.productPrice.clear();
        this.productPrice.sendKeys(productPrice);
    }
    public void provideDropDownInformation(String category,String subCategory,String tax){
        BrowserUtils.selectBy(this.productCategory,category,"text");
        BrowserUtils.selectBy(this.subCategory,subCategory,"text");
        BrowserUtils.selectBy(this.taxBox,tax,"value");
    }

    public void purchaseConfirmation(String description) throws InterruptedException {
        purchaseBox.click();
        this.description.sendKeys(description);
        Thread.sleep(5000);
        saveButton.click();
    }
}
