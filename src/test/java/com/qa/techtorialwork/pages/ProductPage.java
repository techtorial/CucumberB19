package com.qa.techtorialwork.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ProductPage {

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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
    @FindBy(xpath = "//tr[contains(@id,'row')][1]//td")//7
    List<WebElement> allInformation;
    @FindBy(xpath = "//select[@id='category_id']")
    WebElement filterCategory;
    @FindBy(xpath = "//select[@id='sub_category']")
    WebElement filterSubCategory;
    @FindBy(xpath = "//a[contains(@id,'dropdownMenuLink')]")
    List<WebElement> allActionsButton;
    @FindBy(xpath = "//a[.='View']")
    List<WebElement> allViewsButton;
    @FindBy(xpath = "//p[.='Product Category']//following-sibling::p")
    WebElement confirmCategoryName;
    @FindBy(xpath = "//p[.='Product Sub Category']//following-sibling::p")
    WebElement confirmSubCategoryName;

    public void clickAddProductButton() {
        addProductButton.click();
    }

    public void productNameAndPrice(String productName, String productPrice) throws InterruptedException {
        this.productName.sendKeys(productName);
        Thread.sleep(2000);
        this.productPrice.clear();
        this.productPrice.sendKeys(productPrice);
    }

    public void provideDropDownInformation(String category, String subCategory, String tax) {
        BrowserUtils.selectBy(this.productCategory, category, "text");
        BrowserUtils.selectBy(this.subCategory, subCategory, "text");
        BrowserUtils.selectBy(this.taxBox, tax, "value");
    }

    public void purchaseConfirmation(String description) throws InterruptedException {
        purchaseBox.click();
        this.description.sendKeys(description);
        Thread.sleep(5000);
        saveButton.click();
    }

    public void validateProductData(String productName, String productPrice, String confirmation) {
        List<String> expectedData = Arrays.asList(productName, productPrice, confirmation);
        for (int i = 3; i < allInformation.size() - 1; i++) {
            Assert.assertEquals(expectedData.get(i - 3), BrowserUtils.getText(allInformation.get(i)));
        }
    }
    public void chooseCategoryAndSubCategory(String category,String subCategory){
        BrowserUtils.selectBy(filterCategory,category,"text");
        BrowserUtils.selectBy(filterSubCategory,subCategory,"text");
    }
    public void chooseViewOption(){
        allActionsButton.getFirst().click();
        allViewsButton.getFirst().click();
    }

    public void validateInformation(String expectedCategory,String expectedSubCategory){
        Assert.assertEquals(expectedCategory,BrowserUtils.getText(confirmCategoryName));
        Assert.assertEquals(expectedSubCategory,BrowserUtils.getText(confirmSubCategoryName));
    }




}
