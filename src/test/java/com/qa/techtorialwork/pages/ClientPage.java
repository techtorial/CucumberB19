package com.qa.techtorialwork.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ClientPage {

    public ClientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class,'btn-primary')]")
    WebElement addClient;
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(xpath = "//select[@id='country']")
    WebElement country;
    @FindBy(css = "#mobile")
    WebElement phone;
    @FindBy(css = "#company_name")
    WebElement companyName;
    @FindBy(css = "#website")
    WebElement companyWebsite;
    @FindBy(css = "#office")
    WebElement officePhoneNumber;
    @FindBy(css = "#address")
    WebElement companyAddress;
    @FindBy(css = "#shipping_address")
    WebElement companyShippingAddress;
    @FindBy(xpath = "//button[@id='save-client-form']")
    WebElement saveButton;
    @FindBy(xpath = "//tbody//tr[contains(@id,'row')]//td")
    List<WebElement> allData;


    public void clientInformation(String name,String country,String mobile) throws InterruptedException {
        addClient.click();
        this.name.sendKeys(name);
        BrowserUtils.selectBy(this.country,country,"text");
        phone.sendKeys(mobile);
        Thread.sleep(3000);
    }

    public void companyInformation(String companyName,String companyWebsite,String companyPhone) throws InterruptedException {
        this.companyName.sendKeys(companyName);
        this.companyWebsite.sendKeys(companyWebsite);
        this.officePhoneNumber.sendKeys(companyPhone);
        Thread.sleep(3000);
    }

    public void addressInformation(String address,String shippingAddress) throws InterruptedException {
        this.companyAddress.sendKeys(address);
        this.companyShippingAddress.sendKeys(shippingAddress);
        Thread.sleep(3000);
    }

    public void saveAndValidate(String expectedName,String expectedCompany){
        saveButton.click();
        Assert.assertTrue(BrowserUtils.getText(allData.get(2)).contains(expectedName));
        Assert.assertTrue(BrowserUtils.getText(allData.get(2)).contains(expectedCompany));
    }
}
